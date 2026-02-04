import Models.Car

fun main(){
//    val lada = Car( "Лада")
//
//    lada.model = "Капсула смерти"
//    lada.model = ""
//    lada.year = 0
//    lada.price = 100_000_000.0
//
//    println("Машина марки ${lada.brand}, модели ${lada.model}, года выпуска ${lada.year} стоит ${lada.price}")
//
//    val oka = Car("УбейМеняАвоваз", "Ока", -2000, -200_000.0)
//
//    println("Машина марки ${oka.brand}, модели ${oka.model}, года выпуска ${oka.year} стоит ${oka.price}")
//
//    println(oka)
//    println(oka.priceValue)

    val cars = arrayOf<Car>(
        Car("Лада", "Москвич", 2025, 2_000_000.0),
        Car("Митсубиши", "Русский", 666, 0.0),
        Car("УАЗ", "Машина сатаны", 666, 666.66)
    )

    print("Укажите по какому полю сделать поиск: ")
    val field = readlnOrNull() ?: "Марка"

    val results = when (field) {
        "Марка" -> {
            print("Укажите марку машины: ")
            val value = readlnOrNull() ?: "Лада"

            cars.filter { it.brand == value }
        }

        "Модель" -> {
            print("Укажите модель машины: ")
            val value = readlnOrNull() ?: "Русский"

            cars.filter { it.model == value }
        }

        "Год выпуска" -> {
            print("Укажите год выпуска машины: ")
            val value = readlnOrNull()?.toShortOrNull() ?: 2026

            cars.filter { it.year == value }
        }

        "Цена" -> {
            print("Укажите стоимость машины: ")
            val value = readlnOrNull()?.toDoubleOrNull() ?: 0.0

            cars.filter { it.price == value }
        }

        else -> arrayOf<Car>()
    }

    println(results)
}