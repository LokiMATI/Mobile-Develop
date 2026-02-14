package interfaceDataSource

import kotlin.random.Random

class RandomDataSource : DataSource<Int> {
    override fun getNext(): Int = Random.nextInt()
}
