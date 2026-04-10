package com.example.myapplication.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
class Exercise{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("exerciseId")
    var id: Int = 0
    var title: String = ""
    var category: String = ""
    var duration: Int = 0
    var burnCalories: Int = 0

    constructor()

    constructor(
        id: Int,
        title: String,
        category: String,
        duration: Int,
        burnCalories: Int){
        this.id = id
        this.title = title
        this.category = category
        this.duration = duration
        this.burnCalories = burnCalories
    }

    constructor(
        title: String,
        category: String,
        duration: Int,
        burnCalories: Int){
        this.title = title
        this.category = category
        this.duration = duration
        this.burnCalories = burnCalories
    }
}
