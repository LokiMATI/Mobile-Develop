import kotlinx.coroutines.*

suspend fun main(){
    for (i in 0..5){
        println(i)
        delay(1000)
    }

    println("Конец")
}