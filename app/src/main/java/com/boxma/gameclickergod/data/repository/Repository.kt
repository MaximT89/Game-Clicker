package com.boxma.gameclickergod.data.repository

import android.graphics.drawable.BitmapDrawable
import com.boxma.gameclickergod.data.storage.BitmapStorage
import com.boxma.gameclickergod.data.storage.PrefsStatsStorage
import javax.inject.Inject

class Repository @Inject constructor(
    private val bitmapStorage: BitmapStorage,
    private val prefsStatsStorage: PrefsStatsStorage
) {

    fun goblinFrames(): List<BitmapDrawable> = bitmapStorage.goblinFrames()

    fun score(): Int = prefsStatsStorage.loadScore()
    fun score(value: Int) = prefsStatsStorage.saveScore(value)

    fun playerDamage(): Int = prefsStatsStorage.loadPlayerDamage()
    fun playerDamage(value: Int) = prefsStatsStorage.savePlayerDamage(value)

    fun currentWorldLevel(): Int = prefsStatsStorage.loadCurrentWorldLevel()
    fun currentWorldLevel(value: Int) = prefsStatsStorage.saveCurrentWorldLevel(value)

}