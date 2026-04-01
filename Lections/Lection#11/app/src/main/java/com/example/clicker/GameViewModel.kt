package com.example.clicker

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.math.BigDecimal

class GameViewModel(app: Application) : AndroidViewModel(app){
    var score by mutableStateOf(BigDecimal(0))

    val storage = GameStorage(app)
    val upgrades = mutableStateMapOf(
        UpgradeType.AutoClick to Upgrade(
            UpgradeType.AutoClick,
            baseCost = BigDecimal(10.0),
            costMultiplier = BigDecimal(1.5),
            initialValue = BigDecimal(-1.0),
            baseValue = BigDecimal(1.0),
            valueMultiplier = BigDecimal(1.2),
        ),
        UpgradeType.ClickMultiplier to Upgrade(
            UpgradeType.ClickMultiplier,
            baseCost = BigDecimal(10.0),
            costMultiplier = BigDecimal(1.5),
            initialValue = BigDecimal(0.0),
            baseValue = BigDecimal(1.0),
            valueMultiplier = BigDecimal(1.05),
        ),
        UpgradeType.OfflineIncome to Upgrade(
            UpgradeType.OfflineIncome,
            baseCost = BigDecimal(10.0),
            costMultiplier = BigDecimal(1.5),
            initialValue = BigDecimal(-1.0),
            baseValue = BigDecimal(1.0),
            valueMultiplier = BigDecimal(10.0),
        ),
    )

    init {
        viewModelScope.launch {
            score = storage.getScore()
        }
        viewModelScope.launch {
            upgrades[UpgradeType.AutoClick] =
                upgrades[UpgradeType.AutoClick]!!.copy(level = storage.getAutoclick())

            upgrades[UpgradeType.ClickMultiplier] =
                upgrades[UpgradeType.ClickMultiplier]!!.copy(level = storage.getMultiplier())

            upgrades[UpgradeType.OfflineIncome] =
                upgrades[UpgradeType.OfflineIncome]!!.copy(level = storage.getOfflineIncome())
        }
    }

    fun onTap(){
        score += upgrades[UpgradeType.ClickMultiplier]?.currentValue() ?: BigDecimal(1.0)
    }

    fun onAutoClick(){
        score += upgrades[UpgradeType.AutoClick]?.currentValue() ?: BigDecimal(.0)
    }

    fun onUpgrade(upgrade: Upgrade){
        if (score >= upgrade.currentCost()){
            score -= upgrade.currentCost()
            upgrades[upgrade.type] = upgrade.next()
        }
    }

    suspend fun calculateOfflineIncome(): Deferred<BigDecimal>{
        return viewModelScope.async {
            val cap = upgrades[UpgradeType.OfflineIncome]!!.currentValue()
            if (cap > BigDecimal(0)){
                val currentTime = System.currentTimeMillis()
                val exitTime = storage.getExitTime()

                val delta = (currentTime - exitTime) / 1000
                val income = BigDecimal(delta) * upgrades[UpgradeType.AutoClick]!!.currentValue()

                if (income > cap) cap else income
            }
            else BigDecimal(0)
        }
    }

    fun saveData(){
        viewModelScope.launch {
            storage.saveScore(score)
            storage.saveUpgrades(upgrades)
            storage.saveExitTime()
        }
    }
}