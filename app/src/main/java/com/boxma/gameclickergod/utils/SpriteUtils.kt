package com.boxma.gameclickergod.utils

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.BitmapDrawable
import kotlinx.coroutines.*
import java.io.InputStream

object SpriteUtils {

    // Получение картинки из assets
    private fun getBitmapFromAssets(context: Context, filepath: String): Bitmap {

        val assetManager: AssetManager = context.assets
        var istr: InputStream? = null
        var bitmap: Bitmap? = null

        try {
            istr = assetManager.open(filepath)
            bitmap = BitmapFactory.decodeStream(istr)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            istr?.close()
        }

        return bitmap!!
    }

    // Наполняем картинками Bitmap
    fun bitmapToListBitmap(listBitmap : MutableList<Bitmap>, context: Context, filepath: String) =
        listBitmap.add(getBitmapFromAssets(context, filepath))

    // Наполняет аниматор картинками и задает скорость анимации
    fun fillAnimation(
        animationDrawable: AnimationDrawable,
        listBitmap: List<BitmapDrawable>,
        duration: Int,
    ) {
        for (item in listBitmap) animationDrawable.addFrame(item, duration)
    }

}