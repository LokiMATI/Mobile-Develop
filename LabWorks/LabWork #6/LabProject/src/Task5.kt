fun main(){
    val buyPc = createProduct("Ультра ПК", 50_000.0)
    buyPc(2)
    buyPc(5)

    val buyMoscow = createProduct("Москва", 0.0)
    buyMoscow(21)
}

fun createProduct(title : String, price : Double): (Int) -> Unit {
    return {count : Int -> println("В корзину добавлен '$title' на сумму ${price * count}")}
}
