package com.boxma.gameclickergod.presentation.views.gameScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.boxma.gameclickergod.R
import com.boxma.gameclickergod.databinding.FragmentGameBinding


class GameFragment : Fragment(R.layout.fragment_game) {

    lateinit var binding: FragmentGameBinding
    private val gameViewModel by viewModels<GameViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGameBinding.bind(view)
    }

}