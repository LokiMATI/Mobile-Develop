import kotlinx.coroutines.*

suspend fun loadFiles() {
    for (i in 1..30){
        println("Загрузка файла $i")
        delay(3000)
    }
    println("Все файлы загруены")
}

suspend fun main() = coroutineScope {
    println("Если устанете ждать, то введите 'cancel'")
    val loader : Job = launch(Dispatchers.IO) {
        try {
            loadFiles()
        }
        catch (e : CancellationException){
            println("Загрузка отменена")
        }
    }

    if (readln() == "cancel"){
        loader.cancel()
    }
}
