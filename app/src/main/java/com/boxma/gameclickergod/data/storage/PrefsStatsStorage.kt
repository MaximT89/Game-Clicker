package com.boxma.gameclickergod.data.storage

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

private const val APP_PREF = "app_prefs"
private const val PROFILE_SCORE = "profile_score"
private const val PLAYER_DAMAGE = "player_damage"
private const val ENEMY_HP = "enemy_hp"
private const val CURRENT_WORLD_LEVEL = "current_world_level"
private const val MAX_WORLD_LEVEL = "max_world_level"

class PrefsStatsStorage @Inject constructor(
    private val context: Context,
) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE)

    fun loadScore(): Int = preferences.getInt(PROFILE_SCORE, 0)
    fun saveScore(value: Int) = preferences.edit().putInt(PROFILE_SCORE, value).apply()

    fun loadPlayerDamage(): Int = preferences.getInt(PLAYER_DAMAGE, 1)
    fun savePlayerDamage(value: Int) = preferences.edit().putInt(PLAYER_DAMAGE, value).apply()

    fun loadCurrentWorldLevel(): Int = preferences.getInt(CURRENT_WORLD_LEVEL, 1)
    fun saveCurrentWorldLevel(value: Int) = preferences.edit().putInt(CURRENT_WORLD_LEVEL, value).apply()

    fun loadMaxWorldLevel(): Int = preferences.getInt(MAX_WORLD_LEVEL, 1)
    fun saveMaxWorldLevel(value: Int) = preferences.edit().putInt(MAX_WORLD_LEVEL, value).apply()


}