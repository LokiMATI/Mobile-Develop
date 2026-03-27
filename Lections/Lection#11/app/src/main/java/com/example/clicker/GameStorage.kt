package com.example.clicker

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.math.BigDecimal

private val Context.dataStore by preferencesDataStore("game_prefs")

class GameStorage(private val context: Context) {
    private val SCORE_KEY = stringPreferencesKey("score")
    private val AUTOCLICK_KEY = intPreferencesKey("autoclick")
    private val MULTIPLIER_KEY = intPreferencesKey("multiplier")
    private val OFFLONEINCOME_KEY = intPreferencesKey("offline")

    suspend fun getScore(): BigDecimal {
        return context.dataStore.data.map { prefs ->
            BigDecimal(prefs[SCORE_KEY])
        }.first()
    }

    suspend fun saveScore(score: BigDecimal) {
        context.dataStore.edit { prefs ->
            prefs[SCORE_KEY] = score.toString()
        }
    }

    suspend fun saveUpgrades(data: Map<UpgradeType, Upgrade>){
        context.dataStore.edit { prefs ->
            prefs[AUTOCLICK_KEY] = data[UpgradeType.AutoClick]?.level ?: 0
            prefs[MULTIPLIER_KEY] = data[UpgradeType.ClickMultiplier]?.level ?: 0
            prefs[OFFLONEINCOME_KEY] = data[UpgradeType.OfflineIncome]?.level ?: 0
        }
    }

    suspend fun getAutoclick(): Int {
        return context.dataStore.data.map { prefs ->
            prefs[AUTOCLICK_KEY] ?: 0
        }.first()
    }

    suspend fun getMultiplier(): Int {
        return context.dataStore.data.map { prefs ->
            prefs[MULTIPLIER_KEY] ?: 0
        }.first()
    }

    suspend fun getOfflineIncome(): Int {
        return context.dataStore.data.map { prefs ->
            prefs[OFFLONEINCOME_KEY] ?: 0
        }.first()
    }
}