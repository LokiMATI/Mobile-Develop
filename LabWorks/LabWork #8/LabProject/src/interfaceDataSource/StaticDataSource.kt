package interfaceDataSource

class StaticDataSource(val array: IntArray, var index: Int = 0) : DataSource<Int> {
    override fun getNext(): Int {
        if (index >= array.size)
            index = 0

        return array[index++]
    }
}
