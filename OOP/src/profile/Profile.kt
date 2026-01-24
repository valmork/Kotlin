package profile

fun main(){
//    val first = Person("", 2, 2)
//    val second = Person("", 2, 2)

    print("Input 1st age: ")
    val personAgeFirst = readln().toInt()

    print("Input 1st name: ")
    val personNameFirst = readln()

    print("Input 1st lastname: ")
    val personLastNameFirst = readln()

    print("Input 1st height: ")
    val personHeightFirst = readln().toInt()

    print("Input 1st weight: ")
    val personWeightFirst = readln().toInt()

    print("Input 2nd age: ")
    val personAgeSecond = readln().toInt()

    print("Input 2nd name: ")
    val personNameSecond = readln()

    print("Input 2nd lastname: ")
    val personLastNameSecond = readln()

    print("Input 2nd height: ")
    val personHeightSecond = readln().toInt()

    print("Input 2nd weight: ")
    val personWeightSecond = readln().toInt()

    val first = Person(personNameFirst, personLastNameFirst, personHeightFirst, personWeightFirst)
    val second = Person(personNameSecond, personLastNameSecond, personHeightSecond, personWeightSecond)

    println(first.fullName)
    println(second.fullName)

    first.age = personAgeFirst
    second.age = personAgeSecond

    first.showInfo()
    second.showInfo()

    second.lastName = personLastNameFirst

    println(first.fullName)
    println(second.fullName)
}