package com.boxma.gameclickergod.data.repository

import android.graphics.drawable.BitmapDrawable
import com.boxma.gameclickergod.data.storage.BitmapStorage
import com.boxma.gameclickergod.data.storage.SharedPrefProfileStatsStorage

class Repository(
    private val bitmapStorage: BitmapStorage,
    private val sharedPrefProfileStatsStorage: SharedPrefProfileStatsStorage) {

    fun goblinFrames(): List<BitmapDrawable> {
        return bitmapStorage.goblinFrames()
    }

    fun score(): Int {
        return sharedPrefProfileStatsStorage.loadScore()
    }

    fun score(value: Int){
        sharedPrefProfileStatsStorage.saveScore(value)
    }

}