package com.example.clicker

import java.math.BigDecimal

sealed class UpgradeType(val title: String){
    object ClickMultiplier: UpgradeType("Множитель")
    object AutoClick: UpgradeType("Автоклик")
    object OfflineIncome: UpgradeType("Оффлайн доход")
}

data class Upgrade(
    val type: UpgradeType,
    val level: Int = 0,
    val initialValue: BigDecimal,
    val baseValue: BigDecimal,
    val valueMultiplier: BigDecimal,
    val baseCost: BigDecimal,
    val costMultiplier: BigDecimal
){
    fun currentCost(): BigDecimal{
        return baseCost * costMultiplier.pow(level)
    }

    fun currentValue(): BigDecimal{
        return initialValue + baseValue * valueMultiplier.pow(level)
    }

    fun next(): Upgrade{
        return copy(level = level + 1)
    }
}