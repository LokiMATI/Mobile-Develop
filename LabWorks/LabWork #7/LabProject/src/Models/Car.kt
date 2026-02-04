package Models

class Car(_brand : String) {
    var brand : String = ""
        get() {
            return field
        }
        set(value) {
            if (value.length >= 1) {
                field = value
            }
        }
    var model : String = ""
        get() {
            return field
        }
        set(value) {
            if (value.length >= 1) {
                field = value
            }
        }
    var year : Short = 2026
        get() {
            return field
        }
        set(value) {
            if (value >= 0) {
                field = value
            }
        }
    var price : Double = 0.0
        get() {
            return field
        }
        set(value) {
            if (value >= 0.0) {
                field = value
            }
        }
    val priceValue : String
        get() = "Цена: ${price.toInt()}"

    init {
        brand = _brand
    }

    constructor(brand : String,
                model : String,
                year : Short,
                price : Double)
            : this(brand) {
        this.model = model
        this.year = year
        this.price = price
    }

    override fun toString(): String {
        return "Машина марки ${brand}, модели ${model}, года выпуска ${year} стоит ${price}"
    }
}
