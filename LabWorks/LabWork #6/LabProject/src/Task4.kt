import kotlin.math.pow

fun main(){
    print("Введите значение стартовой суммы: ")
    val startSum = readlnOrNull()?.toIntOrNull() ?: 1

    print("Введите значение годового процента: ")
    val percent = readlnOrNull()?.toDoubleOrNull() ?: 2.0

    print("На какое количество лет: ")
    val years = readlnOrNull()?.toIntOrNull() ?: 1

    print("Какую формулу использовать(Сложный процент/Простой процент): ")
    val type = readlnOrNull() ?: "Простой процент"

    try {
        val formula = getFormula(type)
        print("Результат: ${formula(startSum, percent, years)}")
    }
    catch (e: Exception){
        print("ОШИБКА: ${e.message}\nЗА ЭТО ВАМ БУДЕТ ПОЛЬЗА, В ВИДЕ ДОПОЛНИТЕЛЬНОГО СВИНЦА В ОРГАНИЗМ, А ИМЕННО В ГОЛОВУ!")
    }



}

fun getFormula(type : String) : (Int, Double, Int) -> Double{
    return when(type){
        "Простой процент" -> {startSum, percent, years ->
            startSum * (1 + percent / 100 * years)}

        "Сложный процент" -> {startSum, percent, years ->
            startSum * (1 + percent / 100).pow(years)}

        else -> throw IllegalArgumentException("Не указан тип формулы")
    }
}
