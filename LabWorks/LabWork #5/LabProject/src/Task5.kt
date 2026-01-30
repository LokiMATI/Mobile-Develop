import kotlin.random.Random

fun main(){

    var queenCord = Array(8, {intArrayOf(2, 0)})
    var queenCount = 0
    outerloop@ for (i in 0..7){
        for (j in 0..7){
            if (Random.nextBoolean()) {
                print("Ферзь №${queenCount + 1} x: ")
                queenCord[queenCount][0] = readln().toInt()
                print("Ферзь №${queenCount + 1} y: ")
                queenCord[queenCount++][1] = readln().toInt()
                println()
                if (queenCount == 8) break@outerloop
            }
        }
    }

    for (i in queenCord.indices){
        for (j in i + 1..queenCord.lastIndex) {
            if (queenCord[i][0] == queenCord[j][0] ||
                queenCord[i][1] == queenCord[j][1] ||
                queenCord[i][0] - queenCord[i][1] == queenCord[j][0] - queenCord[j][1] ||
                queenCord[i][0] + queenCord[i][1] == queenCord[j][0] + queenCord[j][1]){
                print("Ферзь ${queenCord[i][0]}:${queenCord[i][1]} бьёт ${queenCord[j][0]}:${queenCord[j][1]}")
                return
            }
        }

    }

    println("Ни одна ладья не бьёт другую!")
}
