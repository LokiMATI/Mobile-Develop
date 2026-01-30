fun main(){
    print("Введитие год: ")
    val year = readlnOrNull()?.toInt() ?: 2026

    print("Введите номер месяца: ")
    val mount = readlnOrNull()?.toInt() ?: 12

    val isLeapYear = isLeapYear(year)
    val days = getDaysCount(mount, isLeapYear)
    val season = getSeason(mount)

    println("$year год ${if (isLeapYear) "" else "не "}является високосным")
    println("В месяце номер $mount $days дней")
    println(if (season == "") "Месяц неверно указан" else season)
}

fun isLeapYear(year: Int) : Boolean = year % 4 == 0 && year % 100 != 0 || year % 400 == 0

fun getDaysCount(month: Int, isLeapYear : Boolean = false) : Int{
    return when(month) {
        2 -> if (isLeapYear) 29 else 28
        4, 6, 9, 11 -> 30
        else -> if (month <= 12) 31 else 0
    }
}

fun getSeason(mount: Int) : String{
    return when(mount) {
        in 1..2, 12 -> "Зима"
        in 3..5, -> "Весна"
        in 6..8 -> "Лето"
        in 9..11 -> "Осень"
        else -> ""
    }
}