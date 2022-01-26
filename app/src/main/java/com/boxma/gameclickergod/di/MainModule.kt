package com.boxma.gameclickergod.di

import android.content.Context
import com.boxma.gameclickergod.App
import com.boxma.gameclickergod.data.repository.Repository
import com.boxma.gameclickergod.data.storage.BitmapStorage
import com.boxma.gameclickergod.data.storage.PrefsStatsStorage
import com.boxma.gameclickergod.domain.GenerateEnemyHpUseCase
import com.boxma.gameclickergod.domain.GenerateScoreUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    @Singleton
    @Provides
    fun provideBitmapStorage(@ApplicationContext context: Context): BitmapStorage {
        return BitmapStorage(context)
    }

    @Singleton
    @Provides
    fun providePrefsStatsStorage(@ApplicationContext context: Context): PrefsStatsStorage {
        return PrefsStatsStorage(context)
    }

    @Singleton
    @Provides
    fun provideRepository(
        bitmapStorage: BitmapStorage,
        prefsStatsStorage: PrefsStatsStorage,
    ): Repository {
        return Repository(bitmapStorage, prefsStatsStorage)
    }

    @Singleton
    @Provides
    fun provideGenerateEnemyHpUseCase(repository: Repository): GenerateEnemyHpUseCase {
        return GenerateEnemyHpUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGenerateScoreUseCase(repository: Repository): GenerateScoreUseCase {
        return GenerateScoreUseCase(repository)
    }
}