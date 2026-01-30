fun main(){
    print("Введите сумму, на которую вы хотите отурыть счёт: ")
    var sum = readlnOrNull()?.toDoubleOrNull() ?: 0.0

    print("Введите значение годового прцента: ")
    val percent = (readlnOrNull()?.toDoubleOrNull() ?: 0.0) / 100

    var years = 0
    while(sum < 1_000_000){
        sum += sum * percent
        years++
    }

    println("Через $years лет вы станете миллионером")
}
