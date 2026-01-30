fun main(){
    for (i in 0..9){
        print("$i\t")
    }
    println()
    for (i in 1..9){
        print("$i\t")
        for (j in 1..9){
            print("${i * j}\t")
        }
        println()
    }
}
