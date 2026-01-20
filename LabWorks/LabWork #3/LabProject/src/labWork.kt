import kotlin.math.pow
fun main() {

// Task 1
    print("Введите значение a: ")
    val a : Int = readlnOrNull()?.toIntOrNull() ?: 0

    print("Введите значение b: ")
    val b : Double = readlnOrNull()?.toDoubleOrNull() ?: 1.0

    println("$a + $b = ${a + b}")
    println("$a - $b = ${a - b}")
    println("$a * $b = ${a * b}")
    println("$a / $b = ${a / b}")
    println("$a % $b = ${a % b}")

// Task 2
    print("Введите ваше имя: ")
    val name = readlnOrNull() ?: "Форест"

    print("Введите ваш рост (см): ")
    val height = readlnOrNull()?.toIntOrNull()?: 180

    print("Введите массу вашего тела (кг): ")
    val mass : Double = readlnOrNull()?.toDoubleOrNull() ?: 80.0

    println("$name, ваш ИМТ=${String.format("%.2f", mass / (height / 100.0).pow(2))}")

// Task 3
    print("Введите колчичество секунд, прошедших с начала суток: ")
    var seconds : Int = readlnOrNull()?.toIntOrNull() ?: 0

    seconds %= 86400

    var minutes = seconds / 60
    seconds %= 60
    var hours = minutes / 60
    minutes %= 60

    println("%02d:%02d:%02d".format(hours, minutes, seconds))

// Task 4
    print("Укажите год: ")
    val year = readlnOrNull()!!.toIntOrNull() ?: 2026
    println(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)

// Task 5
    print("Укажите значение внешнего радиуса: ")
    val outerRadius = readlnOrNull()?.toDoubleOrNull() ?: 10.0

    print("Укажите значение внутреннего радиуса: ")
    val innerRadius = readlnOrNull()?.toDoubleOrNull() ?: 5.0

    if (outerRadius <= innerRadius) println("Внешний радиус не может быть больше или меньше, чем внутренний")
    else println("Полщадь кольца равна: ${String.format("%.3f",
        kotlin.math.PI * (outerRadius.pow(2) - innerRadius.pow(2)))}")

}