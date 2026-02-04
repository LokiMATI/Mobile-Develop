fun main(){
    print("Введите значение первого члена прогресии (по умполчпнию 1): ")
    val firstNumber = readlnOrNull()?.toIntOrNull() ?: 1

    print("Введите значение знаменателя прогресии (по умполчпнию 2): ")
    val progressionDenominator = readlnOrNull()?.toIntOrNull() ?: 2

    print("Введите до какого числа необходимо выполнить прогессию (по умполчпнию 1): ")
    val n = readlnOrNull()?.toIntOrNull() ?: 1

    print("Значение $n-го числа прогрессии равно ${getGeometricProgressionValue(progressionDenominator = progressionDenominator, n = n)}")
}

fun  getGeometricProgressionValue(firstNumber : Int = 1, progressionDenominator : Int = 2, n : Int = 1) : Int {
    if (n < 2) return firstNumber

    var number = firstNumber
    for (i in 2..n){
        number *= progressionDenominator
    }
    return number
}
