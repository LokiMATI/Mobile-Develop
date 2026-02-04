fun main(){
    print("Размах ряда: ${getArgsCount(1, 2, 5, 7, 1)}")
}

fun getArgsCount(vararg numbers : Int) : Int {
    return numbers.max() - numbers.min()
}
