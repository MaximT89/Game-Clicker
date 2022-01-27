package com.boxma.gameclickergod.domain

import android.graphics.drawable.BitmapDrawable
import com.boxma.gameclickergod.data.repository.Repository
import javax.inject.Inject

class GetRandomEnemyUseCase @Inject constructor(private val repository: Repository) {

    fun execute(): List<BitmapDrawable> =
        when ((1..2).random()) {
            1 -> repository.goblinFrames()
            2 -> repository.orcFrames()
            else -> repository.orcFrames()
        }


}