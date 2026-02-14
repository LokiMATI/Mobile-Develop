package delivery

interface DeliveryService {
    var title : String

    fun deliver(code : UInt) : Unit
}
