package profile

fun main() {
    val profiles = ProfilesRepository.profiles
        .filter { person: Person -> person.age > 25 }
        .filter { it.gender == Gender.MALE }
        .filter { it.firstName.startsWith("A") }
        .filter { it.age < 30 }

    for (profile in profiles){
        println(profile)
    }
}



fun <R> List<Person>.transform(operation: (Person) -> R): List<R>{
    val result = mutableListOf<R>()
    for (person in this){
        result.add(operation(person))
    }
    return result
}

fun List<Person>.filter(isSuitable: ((Person) -> Boolean)): List<Person>{
    val newProfiles = mutableListOf<Person>()
    for (person in this){
        if (isSuitable(person)){
            newProfiles.add(person)
        }
    }
    return newProfiles
}


