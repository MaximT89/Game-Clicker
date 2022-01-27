package com.boxma.gameclickergod.data.storage

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import com.boxma.gameclickergod.utils.SpriteUtils
import javax.inject.Inject

class BitmapStorage @Inject constructor(
    private val context: Context,
) {

    fun goblinFrames(): List<BitmapDrawable> {
        val frames = mutableListOf<BitmapDrawable>()
        val listBitmap = mutableListOf<Bitmap>()

        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/goblin/hurt/0_Goblin_Idle_000.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/goblin/hurt/0_Goblin_Hurt_000.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/goblin/hurt/0_Goblin_Hurt_001.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/goblin/hurt/0_Goblin_Hurt_002.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/goblin/hurt/0_Goblin_Hurt_003.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/goblin/hurt/0_Goblin_Hurt_004.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/goblin/hurt/0_Goblin_Hurt_005.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/goblin/hurt/0_Goblin_Hurt_006.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/goblin/hurt/0_Goblin_Hurt_007.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/goblin/hurt/0_Goblin_Hurt_008.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/goblin/hurt/0_Goblin_Hurt_009.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/goblin/hurt/0_Goblin_Hurt_010.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/goblin/hurt/0_Goblin_Hurt_011.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/goblin/hurt/0_Goblin_Idle_000.png"))

        for (item in listBitmap) {
            frames.add(BitmapDrawable(context.resources, item))
        }

        return frames
    }

     fun orcFrames(): List<BitmapDrawable> {
        val frames = mutableListOf<BitmapDrawable>()
        val listBitmap = mutableListOf<Bitmap>()

        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/orc/hurt/0_Orc_Idle_000.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/orc/hurt/0_Orc_Hurt_000.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/orc/hurt/0_Orc_Hurt_001.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/orc/hurt/0_Orc_Hurt_002.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/orc/hurt/0_Orc_Hurt_003.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/orc/hurt/0_Orc_Hurt_004.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/orc/hurt/0_Orc_Hurt_005.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/orc/hurt/0_Orc_Hurt_006.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/orc/hurt/0_Orc_Hurt_007.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/orc/hurt/0_Orc_Hurt_008.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/orc/hurt/0_Orc_Hurt_009.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/orc/hurt/0_Orc_Hurt_010.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/orc/hurt/0_Orc_Hurt_011.png"))
        listBitmap.add(SpriteUtils.getBitmapFromAssets(context, "enemy/orc/hurt/0_Orc_Idle_000.png"))

        for (item in listBitmap) {
            frames.add(BitmapDrawable(context.resources, item))
        }

        return frames
    }




}