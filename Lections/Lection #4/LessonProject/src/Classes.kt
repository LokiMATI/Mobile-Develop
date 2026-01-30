import email.Message as Email
fun main(){
    val tom : Person = Person("Tom")
    println(tom.name)
    println(tom.age)

    tom.name = "Tom"
    tom.age = 36

    println(tom.name)
    println(tom.age)

    tom.sayHello()
}
class Person constructor(var name: String){
//    var name : String = _name
    var age : Int = 18

    init {
        name = "qwe " + name
    }

    //Вторичный констрокутор
    constructor(_name : String, age : Int) : this(_name) {
//        name = _name
        this.age = age
    }

    fun sayHello(){
        println("Hello, I`m $name")
    }
}

data     class Cat(val name: String)

open