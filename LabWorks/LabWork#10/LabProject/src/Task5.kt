import kotlinx.coroutines.*

suspend fun sendRequest() : Int {
    println("Подключение к веб-серверу")
    delay(1000)
    return intArrayOf(200, 400, 401, 403, 404, 410, 500).random()
}

suspend fun main() = coroutineScope {
    val responseDeferred = async { sendRequest() }

    println("Код ответа: ${responseDeferred.await()}")
}
