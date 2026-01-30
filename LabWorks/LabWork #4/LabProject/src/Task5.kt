fun main(){
    print("Введите сумму, которую вы внесли: ")
    val count = readlnOrNull()?.toDouble() ?: 0.0

    print("Введите сумму, которую необходимо внести: ")
    var sum = readlnOrNull()?.toDouble() ?: 0.0

    sum = when{
        sum > 5000 -> sum * 0.9
        sum > 1000 -> sum * 0.95
        else -> sum
    }

    val result = when{
        sum == count -> "Спасибо!"
        sum < count -> "Возьмите сдачу: ${count - sum}"
        sum > count -> "Требуется доплатить: ${sum - count}"
        else -> 0
    }

    println(result)
}