fun main(){
    val dictonary = mutableMapOf("Яблоко" to 5.99, "Банан" to 2.55, "Ягода" to 5.42)

    print("Ведите количество вводимых товаров: ")
    val count = readlnOrNull()?.toIntOrNull() ?: 0

    var newProduct : String
    var newPrice : Double?
    if (count > 0)
        do {
            print("Введите название продукта №${dictonary.size + 1}: ")
            newProduct = readln()

            print("Введите цену продукта №${dictonary.size + 1}: ")
            newPrice = readlnOrNull()?.toDoubleOrNull()

            if (newProduct.isEmpty() || newPrice == null)
                continue

            dictonary[newProduct] = newPrice

        } while (dictonary.size < 3 + count)

    println("Количество программно заданных и введённых продуктов: ${dictonary.size}")

    println("Список товаров:")
    dictonary.forEach { println("${it.key} - ${it.value}")}

    print("Введите название продукта: ")
    val key = readln()
    println(if (dictonary.containsKey(key))
        "Цена товара: ${dictonary[key]}"
    else
        "Такого товара нет")

    print("Введите значение: ")
    val searchValue = readlnOrNull()?.toDoubleOrNull()
    if (searchValue == null)
        println("Значение не введено")
    else{
        val valueCount = dictonary.count { it.value == searchValue }
        println("Найдено $valueCount товаров с данной ценой")
    }

    print("Введите название продукта, чтобы его удалить: ")
    val keyRemove = readln()
    println(if (dictonary.containsKey(keyRemove))
        dictonary.remove(keyRemove)
    else
        "Такого товара нет")

    println("Список товаров:")
    dictonary.forEach { println("${it.key} - ${it.value}")}
}