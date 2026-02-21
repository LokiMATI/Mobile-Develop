import kotlinx.coroutines.*

suspend fun main() : Unit = coroutineScope {
    launch { countSheeps() }
    launch { countCats() }
    println("Поток в main: ${Thread.currentThread().name}")
}

suspend fun countSheeps() {
    for (i in 1..500)
        println("$i овечка. Поток в countSheeps: ${Thread.currentThread().name}")

    delay(1000)

    for (i in 501..1000)
        println("$i овечка. Поток в countSheeps: ${Thread.currentThread().name}")
}

suspend fun countCats() {
    for (i in 1..500){
        println("$i котик. Поток в countCats: ${Thread.currentThread().name}")
        delay(10)
    }
}