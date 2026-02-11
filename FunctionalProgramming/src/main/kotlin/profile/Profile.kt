package profile

fun main() {
    val profiles = ProfilesRepository.profiles

    val olderThan25: (Person) -> Boolean = { person: Person -> person.age > 25 }

    var filterd = filter(profiles) { it.age > 25 }

    filterd = filter(filterd) { it.gender == Gender.MALE }
    filterd = filter(filterd) {it.firstName.startsWith("A")}
    filterd = filter(filterd) {it.age < 30}
    for (profile in filterd){
        println(profile)
    }
}

fun filter(profiles: List<Person>, isSuitable: ((Person) -> Boolean)): List<Person>{
    val newProfiles = mutableListOf<Person>()
    for (person in profiles){
        if (isSuitable(person)){
            newProfiles.add(person)
        }
    }
    return newProfiles
}


//fun filter(profiles: List<Person>, condition: Condition): List<Person>{
//    val newProfiles = mutableListOf<Person>()
//    for (person in profiles){
//        if (condition.isSuitable(person)){
//            newProfiles.add(person)
//        }
//    }
//    return newProfiles
//}

