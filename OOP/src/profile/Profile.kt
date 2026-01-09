package profile

fun main(){
    val first = Person("", 2, 2, 2)
    val second = Person("", 2, 2, 2)

    print("Input 1st age: ")
    val personAgeFirst = readln().toInt()

    print("Input 1st name: ")
    val personNameFirst = readln()

    print("Input 1st height: ")
    val personHeightFirst = readln().toInt()

    print("Input 1st weight: ")
    val personWeightFirst = readln().toInt()

    print("Input 2nd age: ")
    val personAgeSecond = readln().toInt()

    print("Input 2nd name: ")
    val personNameSecond = readln()

    print("Input 2nd height: ")
    val personHeightSecond = readln().toInt()

    print("Input 2nd weight: ")
    val personWeightSecond = readln().toInt()

//    println("1. Name: ${first.name} Age: ${first.age} Height: ${first.height} Weight: ${first.weight}")
//    println("2. Name: ${second.name} Age: ${second.age} Height: ${second.height} Weight: ${second.weight}")
//
//    first.run()
//    second.run()

//    first.init(name = personNameFirst, age = personAgeFirst, weight = personWeightFirst, height = personHeightFirst)
//    second.init(name = personNameSecond, age = personAgeSecond, weight = personWeightSecond, height = personHeightSecond)
    first.showInfo()
    second.showInfo()
}