package com.boxma.gameclickergod.di

import android.content.Context
import com.boxma.gameclickergod.data.repository.Repository
import com.boxma.gameclickergod.data.storage.BitmapStorage
import com.boxma.gameclickergod.data.storage.PrefsStatsStorage
import com.boxma.gameclickergod.domain.GenerateEnemyHpUseCase
import com.boxma.gameclickergod.domain.GenerateScoreUseCase
import com.boxma.gameclickergod.domain.GetRandomEnemyUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun provideRepository(
        @ApplicationContext context: Context,
        bitmapStorage: BitmapStorage
    ): Repository {
        return Repository(context, bitmapStorage)
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

    @Singleton
    @Provides
    fun provideGetRandomEnemyUseCase(repository: Repository): GetRandomEnemyUseCase {
        return GetRandomEnemyUseCase(repository)
    }
}