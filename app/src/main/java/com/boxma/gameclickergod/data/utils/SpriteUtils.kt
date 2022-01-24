package com.boxma.gameclickergod.data.utils

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.InputStream

object SpriteUtils {

    // Получение картинки из assets
    fun getBitmapFromAssets(context: Context, filepath: String) : Bitmap {
        val assetManager: AssetManager = context.assets
        var istr: InputStream? = null
        var bitmap: Bitmap? = null

        try {
            istr = assetManager.open(filepath)
            bitmap = BitmapFactory.decodeStream(istr)
        } catch (e : Exception){
            e.printStackTrace()
        } finally {
            istr?.close()
        }

        return bitmap!!
    }

}