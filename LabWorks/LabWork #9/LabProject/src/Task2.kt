fun main(){
    print("Ведите количество вводимых значений: ")
    val elementsCount = readlnOrNull()?.toIntOrNull() ?: 0

    if (elementsCount == 0)
        return

    val list = mutableListOf<Int>()

    for (i in 0..<elementsCount){
        print("Введите название №$i элемента: ")
        list.add(readlnOrNull()?.toIntOrNull() ?: 0)
    }

    val oneHundredIndex = list.indexOfFirst { it == 100 }
    println(if (oneHundredIndex == -1)
        "В списке элемента со значением 100 нет"
    else
        "Индекс элемента со значением 100 равен $oneHundredIndex")

    println("Сумма элементов списка: ${list.sum()}")

    println("Среднее арефметическое списка: ${list.sum() / list.size}")

    println(if (list.all {it > 0})
        "Все значения больше нуля"
    else
        "Не все значения больше нуля")

    val oddNumbers = list.filter { it % 2 == 1 }
    println(if (oddNumbers.isNotEmpty())
        "Нечётные значения списка: $oddNumbers"
    else
        "В списке нет нечётных значений")
}
