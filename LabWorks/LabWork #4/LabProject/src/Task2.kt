fun main(){
    print("Введите значение стороны a: ")
    val a = readlnOrNull()?.toInt() ?: 0

    print("Введите значение стороны b: ")
    val b = readlnOrNull()?.toInt() ?: 0

    print("Введите значение стороны c: ")
    val c = readlnOrNull()?.toInt() ?: 0

    val isExists = a < b + c && b < a + c && c < a + c

    if (isExists) {
        println("Треугольник сущестует")

        when {
            (a == b && a == c) -> println("Треугольник равносторонний и равнобедренный")
            (a == b || a == c || b == c) -> println("Треугольник равнобедренный")
            else -> println("Треугольник разносторонний")
        }
    }
    else {
        println("Треугольника не существует")
    }
}