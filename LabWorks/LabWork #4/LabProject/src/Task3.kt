import java.math.BigDecimal
import java.math.RoundingMode

fun main(){
    print("Введиите сумму в рублях: ")
    val count = readlnOrNull()?.toInt() ?: 0

    print("В какую валюту ковертировать ('евро' или 'доллар'): ")
    val currency = readln().trim()

    val result = (when(currency){
        "евро" -> count * 90.0
        "доллар" -> count * 0.5
        else -> count
    }).toString()

    println("Результат: ${BigDecimal(result).setScale(2, RoundingMode.HALF_UP)}")
}