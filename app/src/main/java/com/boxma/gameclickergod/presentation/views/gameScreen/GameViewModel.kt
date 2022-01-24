package com.boxma.gameclickergod.presentation.views.gameScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.boxma.gameclickergod.data.repository.Repository

class GameViewModel(private val repository: Repository) : ViewModel() {

    var score = MutableLiveData<Int>(repository.score())

    fun score(value: Int){
        score.value = score.value!! + value
        repository.score(score.value!!)
    }

    fun score(): Int = repository.score()
}