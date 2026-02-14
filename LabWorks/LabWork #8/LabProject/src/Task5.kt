import delivery.DeliveryApplication
import delivery.DeliveryService
import delivery.FoodService

fun main(){
    val service : DeliveryService = FoodService("Сдохни или умри")

    print("Тестовый вызов: ")
    service.deliver(42u)

    val application = DeliveryApplication(service)

    application.deliver(42U)
}