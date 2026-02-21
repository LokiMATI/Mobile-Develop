import kotlinx.coroutines.*

suspend fun connectDataBase() {
    for (i in 1..5){
        println("Попытка подключения к БД")
        delay(3000)
    }
    println("Подеючение успешно")
}

suspend fun main() = coroutineScope<Unit> {
    try {
        withTimeout(10000) { connectDataBase() }
    }
    catch (e : TimeoutCancellationException){
        println("Превышено время ожидания")
    }
}
