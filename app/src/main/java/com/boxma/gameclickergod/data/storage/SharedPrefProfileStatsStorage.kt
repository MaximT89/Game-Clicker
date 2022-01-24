package com.boxma.gameclickergod.data.storage

import android.content.Context
import android.content.SharedPreferences

private const val APP_PREF = "app_prefs"
private const val PROFILE_SCORE = "profile_score"

class SharedPrefProfileStatsStorage(private val context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE)

    fun loadScore(): Int {
        return preferences.getInt(PROFILE_SCORE, 0)
    }

    fun saveScore(value: Int) {
        preferences.edit().putInt(PROFILE_SCORE, value).apply()
    }


}