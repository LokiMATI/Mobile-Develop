package com.example.clicker

import java.math.BigDecimal
import java.math.RoundingMode

fun BigDecimal.formatNumber(scale: Int = 0): String{
    val suffixes = " abcdefghijklmnopqrstuvwxyz"
    var count = 0
    var num = this

    while (num > BigDecimal(1000) && count < suffixes.length){
        num /= BigDecimal(1000)
        count++
    }

    return  "${num.setScale(scale, RoundingMode.FLOOR)}${suffixes[count].uppercase()}"
}