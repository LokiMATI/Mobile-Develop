import interfaceDataSource.DataSource
import interfaceDataSource.RandomDataSource
import interfaceDataSource.StaticDataSource

fun main(){
    var dataSource : DataSource<Int> = RandomDataSource()
    for(i in 1..10)
        println("RandomDataSource $i: ${dataSource.getNext()}")


    dataSource = StaticDataSource(intArrayOf(1, 2, 3, 4, 5, 6))
    for(i in 1..10)
        println("StaticDataSource $i: ${dataSource.getNext()}")
}
