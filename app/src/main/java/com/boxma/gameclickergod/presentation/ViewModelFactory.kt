package com.boxma.gameclickergod.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.boxma.gameclickergod.data.repository.Repository
import com.boxma.gameclickergod.presentation.views.gameScreen.GameViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == GameViewModel::class.java){
            return GameViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}