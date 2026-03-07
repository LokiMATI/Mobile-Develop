package figure

import kotlin.math.PI
import kotlin.math.pow

class Circle : Figure() {
    var radius: Double = 1.0
    override val title: String = "Circle"

    override fun getSquare(): Double = PI * radius.pow(2)

    override fun getPerimeter(): Double = PI * 2 * radius

    override fun getInfo(): String = "Це коло"
}