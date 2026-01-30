fun main(){
    print("Введите значение a: ")
    val a = readlnOrNull()?.toDoubleOrNull() ?: 0.0

    print("Введите значение b: ")
    val b = readlnOrNull()?.toDoubleOrNull() ?: 0.0

    print("Введите значение x1: ")
    var x1 = readlnOrNull()?.toIntOrNull() ?: 0

    print("Введите значение x2: ")
    val x2 = readlnOrNull()?.toIntOrNull() ?: 0

    for (i in x1..x2 step 1){
        println("$a * $i + $b = ${i * a + b}")
    }
}
