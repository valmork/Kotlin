package homework

import kotlin.random.Random

class Monster {
    val pawsCount: Int
    val eyesCount: Int
    val fangsCount: Int
    val clawsCount: Int
    val tentaclesCount: Int

    constructor(pawsCount: Int, eyesCount: Int, fangsCount: Int, clawsCount: Int, tentaclesCount: Int) {
        this.pawsCount = pawsCount
        this.eyesCount = eyesCount
        this.fangsCount = fangsCount
        this.clawsCount = clawsCount
        this.tentaclesCount = tentaclesCount
    }

    constructor(number: Int): this(number, number, number,
        number, number)

    constructor(){
        this.pawsCount = Random.nextInt(1, 10)
        this.eyesCount = Random.nextInt(1, 10)
        this.fangsCount = Random.nextInt(1, 10)
        this.clawsCount = Random.nextInt(1, 10)
        this.tentaclesCount = Random.nextInt(1, 10)
    }
    fun printInfo(){
        println("Кол-во лап: $pawsCount\nКол-во глаз: $eyesCount\n" +
                "Кол-во клыков: $fangsCount\nКол-во когтей: $clawsCount\nКол-во щупалец: $tentaclesCount")
    }
}

//fun homework.homework.task(){
//    val source = readln()
//    val sourceElements = source.split(" ")
//    val pawsCount = sourceElements[0].toInt()
//    val eyesCount = sourceElements[1].toInt()
//    val fangsCount = sourceElements[2].toInt()
//    val clawsCount = sourceElements[3].toInt()
//    val tentaclesCount = sourceElements[4].toInt()
//    val monster = homework.Monster(pawsCount, eyesCount, fangsCount, clawsCount, tentaclesCount)
//    monster.printInfo()
//}