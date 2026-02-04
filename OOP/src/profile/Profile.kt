package profile

fun main(){
    val person1 = Person("John", "Cob", 180, 21)
    val person2 = Person("John", "Cob", 180, 21)
    val person3 = person1.copy(lastName = "Korolev")
    val people = setOf<Person>(person1, person2, person3)
    for (person in people){
        println(person)
    }
}