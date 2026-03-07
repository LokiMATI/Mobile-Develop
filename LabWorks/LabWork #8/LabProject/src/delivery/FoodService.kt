package delivery

class FoodService(override var title: String) : DeliveryService {
    override fun deliver(code: UInt) {
        println("Заказ $code передан в доставку через $title")
    }
}
