fun main(){
    val array = mutableListOf("Архангельск", "Северодвинск", "Новодвинск")

    print("Ведите количество вводимых городов: ")
    val citiesCount = readlnOrNull()?.toIntOrNull() ?: 0

    var newCity : String
    for (i in 1..citiesCount){
        print("Введите название №$i города: ")
         newCity = readln()

        if (newCity == ""){
            continue
        }

        array.add(newCity)
    }

    println("Количество программно заданных и введённых названий городов: ${array.size}")

    for (i in array.indices){
        println("${i + 1} - ${array[i]}")
    }
}
