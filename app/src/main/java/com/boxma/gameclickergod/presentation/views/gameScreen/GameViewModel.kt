package com.boxma.gameclickergod.presentation.views.gameScreen

import android.graphics.drawable.BitmapDrawable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.boxma.gameclickergod.data.repository.Repository
import com.boxma.gameclickergod.domain.GenerateEnemyHpUseCase
import com.boxma.gameclickergod.domain.GenerateScoreUseCase
import com.boxma.gameclickergod.domain.GetRandomEnemyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.security.PrivateKey
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val repository: Repository,
    private val enemyHpUseCase: GenerateEnemyHpUseCase,
    private val scoreUseCase: GenerateScoreUseCase,
    private val enemyUseCase: GetRandomEnemyUseCase,
) : ViewModel() {

    private var playerDamage = MutableLiveData(repository.playerDamage())
    var score = MutableLiveData(repository.score())
    var totalPlayerDamage = MutableLiveData(0)
    var enemyHp = MutableLiveData(enemyHpUseCase.execute())
    var tempEnemyHp = MutableLiveData<Int>(enemyHp.value)
    var currentLevel = MutableLiveData(repository.currentWorldLevel())
    var enemyBitmap = MutableLiveData<List<BitmapDrawable>>()

    fun setScore(value: Int) {
        repository.score(value)
        score.value = repository.score()
    }

    fun setCurrentLevel(value: Int) = repository.currentWorldLevel(value)

    private fun score(value: Int) {
        score.value = score.value!! + value
        repository.score(score.value!!)
    }

    fun increaseTotalDamage() {
        totalPlayerDamage.value = totalPlayerDamage.value!! + playerDamage.value!!
        updateTempEnemyHp()
    }

    private fun updateTempEnemyHp() {
        tempEnemyHp.value = enemyHp.value!! - totalPlayerDamage.value!!
        if (tempEnemyHp.value!! <= 0) {
            increaseScore()
            increaseLevel()
            cleanEnemyHp()
            generateNewEnemy()
        }
    }

    private fun increaseLevel() = repository.currentWorldLevel(value = repository.currentWorldLevel() + 1)
    private fun increaseScore() = score(scoreUseCase.scoreCurrentLevel())

    fun generateNewEnemy() {
        enemyHp.value = enemyHpUseCase.execute()
        cleanTotalDamage()
        cleanTempEnemyHp()
        getEnemyBitmap()
    }

    fun getEnemyBitmap() {
        enemyBitmap.value = enemyUseCase.execute()
    }

    private fun cleanEnemyHp() {
        tempEnemyHp.value = 0
    }

    private fun cleanTempEnemyHp() {
        tempEnemyHp.value = enemyHp.value
    }

    private fun cleanTotalDamage() {
        totalPlayerDamage.value = 0
    }


}