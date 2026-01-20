import kotlin.math.ceil
import kotlin.math.roundToInt
import kotlin.random.Random

// Учебный проект

/*
Даная леция была записана
14.01.2026
 */

fun main() {
    println("Hello, World!")
    println("Hello, World!")

    //Целочисленные
    var b : Byte //-128~127
    var s : Short //-32768~32767
    var n : Int = 1 //-2млрд~2млрд
    var l : Long // -9*10^18~9*10^18

    var ui : UInt = 1U
    var nb = 0b0011
    var nh = 0xff

    //Вещественные
    var f : Float = 3.14F
    var d : Double = 3.34e-3 // 3.14 * 10^-3

    //Логический
    var isTrue : Boolean = true
    var isFalse : Boolean = false

    //Символьные
    var c : Char = 'A'
    var str : String = "Hello, World!"
    var longText = """
        Много
        много
        строк
    """.trimIndent()

    var x = 15
    var y = 5

    var result = "$x + $y = ${x + y}"

    var format = String.format("%.2f %d", f, n)

    //Преобразование типов
    f = d.toFloat()

    var obj : Any

    //Диапазоны
    val range = 1..5 step 2
    var range1 = 1..<5
    var range2 = 1 until 5
    var range3 = 5 downTo 1

    println(range.toList())

    var data = readln()
    println(data)

    Random.nextDouble(1.0, 5.0)
    d.roundToInt()
    ceil(d)
    kotlin.math.floor(d)
    kotlin.math.round(d)

    //Побитовые операции
    println(3 shl 2) //11 << 2 = 1100 = 12
    println(3 shr 2) //11 >> 2 = 0

    // and, or, xor, .inv(), .not()

    //Логические операции
    // and, or, not, in
    // && || !

    //Условный оператор
    var i = readln().toInt()

    var j = if (i > 0) {
        1
    } else if (i < 0) {
        2
    } else {
        3
    }

    when(i) {
        1 -> println()
        2,3 -> println()
        4 + j -> println()
        in 5 .. 7 -> println()
        else -> {
            println()
        }
    }

    when{
        i > 0 -> println()
        i == 0 -> println()
    }

    //Циклы
    for (m in 1 .. 10 step 2) {
        println(m)
    }

    /*
    while (true) {

    }

    do {

    } while (true)

    break
    continue
    */

//    outerloop@ for (i1 in 1..10 step 2) {
//        for (i2 in 1..10 step 2) {
//            break@outerloop
//        }
//    }

    //Массивы
    val numbers : Array<Int> = arrayOf(1,2,3,4,5)
    val empty = arrayOf<Int>(3)
    var numbers1 = Array(3, {5}) // 5, 5, 5
    i = 1
    var numbers2 = Array(3, {i++*2}) // 2, 4, 6

    numbers[0] = 1

    for (num in numbers) {
        println(num)
    }
    for (i1 in 0 ..< numbers1.size) {
        println(numbers1[i1])
    }
    for (i1 in 0 .. numbers1.lastIndex) {
        println(numbers1[i1])
    }
    for (i1 in numbers1.indices) {
        println(numbers1[i1])
    }

    val intArray = intArrayOf(1,2,3,4,5)
}