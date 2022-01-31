package com.boxma.gameclickergod.data.repository

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import com.boxma.gameclickergod.base.BaseSharedPreferences
import com.boxma.gameclickergod.data.storage.BitmapStorage
import com.boxma.gameclickergod.data.storage.PrefsStatsStorage
import com.boxma.gameclickergod.data.storage.PrefsStatsStorage.currentWorldLevel
import com.boxma.gameclickergod.data.storage.PrefsStatsStorage.playerDamage
import com.boxma.gameclickergod.data.storage.PrefsStatsStorage.score
import javax.inject.Inject

class Repository @Inject constructor(
    context: Context,
    private val bitmapStorage: BitmapStorage,
) {
    private val prefs = PrefsStatsStorage.defaultPref(context)

    fun goblinFrames() = bitmapStorage.goblinFrames()
    fun orcFrames() = bitmapStorage.orcFrames()

    fun score(): Int = prefs.score
    fun score(value: Int) {
        prefs.score = value
    }

    fun playerDamage(): Int = prefs.playerDamage
    fun playerDamage(value: Int) {
        prefs.playerDamage = value
    }

    fun currentWorldLevel(): Int = prefs.currentWorldLevel
    fun currentWorldLevel(value: Int) {
        prefs.currentWorldLevel = value
    }

}