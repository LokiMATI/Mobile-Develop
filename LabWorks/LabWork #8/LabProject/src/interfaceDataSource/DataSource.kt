package interfaceDataSource

interface DataSource<T> {
    fun getNext() : T
}
