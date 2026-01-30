import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.cos
import kotlin.math.sqrt
import java.math.BigDecimal
import java.math.RoundingMode
fun main(){
    print("Введите значение a: ")
    val a = readlnOrNull()?.toDouble() ?: 0.0

    print("Введите значение x: ")
    val x = readlnOrNull()?.toDouble() ?: 0.0

    var result : Double
    when {
        x < 0 -> result = a + x.pow(3)
        x < 3 -> result = sin(x) + cos(x)
        x < 5 -> {
            if (a == x) {
                print("ЧИСЛО НЕ МОЕТ БЫТЬ ОТРИЦАТЕЛЬНЫМ В ЗНАМЕНАТЕЛЕ!!! РАССТРЕЛЯТЬ!")
                return
            }
            result = 1 / (a - x)
        }
        else -> {
            if (x < a) {
                print("ЧИСЛО НЕ МОЕТ БЫТЬ ОТРИЦАТЕЛЬНЫМ ПОД КОРЕМ!!! РАССТРЕЛЯТЬ!")
                return
            }

            result = sqrt(x - a)}
    }

    println("Результат ${BigDecimal(result.toString()).setScale(3, RoundingMode.HALF_UP)}")
}