package human

open class Human {
    var name : String
    var age : Int
    open val info : String
        get() = "Имя: $name\nВозраст: $age"

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    override fun toString(): String = "Имя: $name\nВозраст: $age"
}
