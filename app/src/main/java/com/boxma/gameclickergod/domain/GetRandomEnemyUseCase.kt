package com.boxma.gameclickergod.domain

import com.boxma.gameclickergod.data.repository.Repository
import javax.inject.Inject

class GetRandomEnemyUseCase @Inject constructor(private val repository: Repository) {

    fun execute() = when ((1..2).random()) {
        1 -> repository.goblinFrames()
        2 -> repository.orcFrames()
        else -> repository.orcFrames()
    }
}