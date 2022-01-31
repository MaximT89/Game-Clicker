package com.boxma.gameclickergod.base

import android.content.Context
import android.content.SharedPreferences

interface BaseSharedPreferences {

    companion object {
        private const val APP_PREF = "app_prefs"
    }

    fun SharedPreferences.Editor.put(pair: Pair<String, Any>): SharedPreferences.Editor =
        when (val value = pair.second) {
            is String -> putString(pair.first, value)
            is Int -> putInt(pair.first, value)
            is Boolean -> putBoolean(pair.first, value)
            is Long -> putLong(pair.first, value)
            is Float -> putFloat(pair.first, value)
            else -> error("Only primitive types can be stored in SharedPreferences")
    }

    fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) =
        edit().also(operation).apply()

    fun defaultPref(context: Context): SharedPreferences =
        context.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE)

}