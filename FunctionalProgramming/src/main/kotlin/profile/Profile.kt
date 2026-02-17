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



fun <R, T> List<T>.transform(operation: (T) -> R): List<R>{
    val result = mutableListOf<R>()
    for (person in this){
        result.add(operation(person))
    }
    return result
}




