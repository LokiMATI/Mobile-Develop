import kotlin.random.Random

fun main(){
    var randomInt = Random.nextInt(10)
    print("Угадайте число от 1 до 10: ")
    var int : Int
    do {
        int = readlnOrNull()?.toIntOrNull() ?: 1
        when{
            int > randomInt -> print("Загаданное число меньше. Попробуйте снова: ")
            int < randomInt -> print("Загаданное число больше. Попробуйте снова: ")
            else -> print("Вы угадали! Молодец!")
        }
    } while (int != randomInt)
}
