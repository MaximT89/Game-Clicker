package com.boxma.gameclickergod.presentation.views.gameScreen

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.boxma.gameclickergod.R
import com.boxma.gameclickergod.base.BaseFragment
import com.boxma.gameclickergod.databinding.FragmentGameBinding
import com.boxma.gameclickergod.utils.SpriteUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GameFragment : BaseFragment<FragmentGameBinding>() {

    private val gameViewModel: GameViewModel by viewModels()
    private lateinit var enemyAnimator: AnimationDrawable

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentGameBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        setupObservers()
        setupAnimators()
        createEnemy()

        binding.clickField.setOnClickListener {
            startAnimation(enemyAnimator)
            damageToEnemy()
        }
    }

    private fun init() {
        binding.reloadBtn.setOnClickListener {
            with(gameViewModel) {
                setCurrentLevel(1)
                setScore(1)
                generateNewEnemy()
            }
        }
    }

    private fun damageToEnemy() = gameViewModel.increaseTotalDamage()

    private fun reloadAnimation(animator: AnimationDrawable) {
        stopAnimationRoot(animator)
        startAnimationRoot(animator)
    }

    private fun startAnimation(animator: AnimationDrawable) = reloadAnimation(animator)
    private fun startAnimationRoot(animator: AnimationDrawable) = animator.start()

    private fun stopAnimationRoot(animator: AnimationDrawable) {
        if (animator.isRunning) animator.stop()
    }

    private fun createEnemy() = gameViewModel.getEnemyBitmap()

    private fun setupAnimators() {
        enemyAnimator = AnimationDrawable()
            .apply {
                isOneShot = true
                setVisible(true, true)
            }
    }

    private fun setupObservers() {

        with(gameViewModel) {

            score.observe(this@GameFragment, {
                binding.textScore.text = it.toString()
            })

            tempEnemyHp.observe(this@GameFragment, {
                with(binding) {
                    enemyHpProgressBar.progress = it
                    enemyHpText.text = it.toString()
                }
            })

            enemyHp.observe(this@GameFragment, {
                binding.enemyHpProgressBar.max = it
            })

            score.observe(this@GameFragment, {
                binding.textScore.text = it.toString()
            })

            enemyBitmap.observe(this@GameFragment, {
                setupAnimators()
                SpriteUtils.fillAnimation(enemyAnimator, it, 40)
                binding.imageViewEnemy.background = enemyAnimator
            })

        }
    }


}