import human.*

fun main(){
    val human = Human("Никита", 19)
    println(human)
    println(human.info)

    val student = Student("Никита", 19, "ИСПП-31")
    println(student)
    println(student.info)
}
