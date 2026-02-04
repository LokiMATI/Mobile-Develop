import kotlin.math.pow
import kotlin.math.PI

fun main(){
    print("Введите значение радиуса окружности: ")
    val radius = readlnOrNull()?.toDoubleOrNull() ?: 1.0
    println("Площадь круга: ${squarePi(radius)}")

    print("Введите значение малого радиуса элипса: ")
    val smallRadius = readlnOrNull()?.toDoubleOrNull() ?: 1.0

    print("Введите значение большого радиуса элипса: ")
    val largerRadius = readlnOrNull()?.toDoubleOrNull() ?: 2.0
    println("Площадь элипса: ${squarePi(smallRadius, largerRadius)}")
}

fun squarePi(radius : Double) : Double{
    return radius.pow(2) * PI
}

fun squarePi(smallRadius : Double, largerRadius : Double ) : Double{
    return smallRadius * largerRadius * PI
}
