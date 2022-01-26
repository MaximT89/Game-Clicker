package com.boxma.gameclickergod.domain

import com.boxma.gameclickergod.data.repository.Repository
import com.boxma.gameclickergod.utils.Constants
import javax.inject.Inject

class GenerateEnemyHpUseCase @Inject constructor(
    private val repository: Repository,
) {
    fun execute(): Int = repository.currentWorldLevel() * Constants.ratioEnemyHp
}