package com.boxma.gameclickergod.presentation.views.gameScreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.boxma.gameclickergod.R
import com.boxma.gameclickergod.data.repository.Repository
import com.boxma.gameclickergod.data.storage.BitmapStorage
import com.boxma.gameclickergod.data.storage.SharedPrefProfileStatsStorage
import com.boxma.gameclickergod.databinding.FragmentGameBinding
import com.boxma.gameclickergod.presentation.ViewModelFactory


class GameFragment : Fragment(R.layout.fragment_game) {

    lateinit var binding: FragmentGameBinding
    private lateinit var bitmapStorage: BitmapStorage
    private lateinit var repository: Repository
    private lateinit var gameViewModel: GameViewModel
    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var sharedPrefProfileStatsStorage: SharedPrefProfileStatsStorage

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGameBinding.bind(view)

        setupViewModel()
        setupScene()
        setupObservers()

        binding.clickField.setOnClickListener {
            gameViewModel.score(1)
        }
    }

    private fun setupScene() {
        gameViewModel.score()
    }

    private fun setupViewModel() {
        bitmapStorage = BitmapStorage(requireActivity())
        sharedPrefProfileStatsStorage = SharedPrefProfileStatsStorage(requireActivity())
        repository = Repository(bitmapStorage, sharedPrefProfileStatsStorage)
        viewModelFactory = ViewModelFactory(repository)
        gameViewModel = ViewModelProvider(requireActivity(), viewModelFactory)[GameViewModel::class.java]
    }

    private fun setupObservers() {
        gameViewModel.score.observe(this, {
            binding.score.text = it.toString()
        })
    }

}