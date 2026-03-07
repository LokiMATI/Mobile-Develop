package human
class Student : Human {
    var group : String
    override val info : String
        get() = "${super.info}\nГруппа: $group"

    constructor(name: String, age: Int, group: String) : super(name, age) {
        this.group = group
    }

    override fun toString(): String {
        // Дочерняя реализация
        return "${super.toString()}\nГруппа: $group"
    }
}
