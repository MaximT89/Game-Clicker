package com.boxma.gameclickergod.data.storage

import android.content.SharedPreferences
import com.boxma.gameclickergod.base.BaseSharedPreferences

object PrefsStatsStorage : BaseSharedPreferences {

    private const val PLAYER_DAMAGE = "player_damage"
    private const val ENEMY_HP = "enemy_hp"
    private const val CURRENT_WORLD_LEVEL = "current_world_level"
    private const val MAX_WORLD_LEVEL = "max_world_level"
    private const val PROFILE_SCORE = "profile_score"

    var SharedPreferences.score
        get() = getInt(PROFILE_SCORE, 0)
        set(value) = editMe {
            it.put(PROFILE_SCORE to value)
        }

    var SharedPreferences.playerDamage
        get() = getInt(PLAYER_DAMAGE, 1)
        set(value) = editMe {
            it.put(PLAYER_DAMAGE to value)
        }


    var SharedPreferences.currentWorldLevel
        get() = getInt(CURRENT_WORLD_LEVEL, 1)
        set(value) = editMe {
            it.put(CURRENT_WORLD_LEVEL to value)
        }

    var SharedPreferences.maxWorldLevel
        get() = getInt(MAX_WORLD_LEVEL, 1)
        set(value) = editMe {
            it.put(MAX_WORLD_LEVEL to value)
        }

    var SharedPreferences.clearValues
        get() = run { }
        set(value) = editMe {
            it.clear()
        }
}