package delivery

class DeliveryApplication(val service: DeliveryService): DeliveryService by  service
