package profile

fun main() {
    val profiles = ProfilesRepository.profiles
    var filterd = filter(profiles, object : Condition {
        override fun isSuitable(person: Person): Boolean {
            return person.age > 25
        }
    })
    filterd = filter(filterd, object : Condition {
        override fun isSuitable(person: Person): Boolean {
            return person.gender == Gender.MALE
        }
    })
    filterd = filter(filterd, object : Condition {
        override fun isSuitable(person: Person): Boolean {
            return person.firstName.startsWith("A")
        }
    })
    filterd = filter(filterd, object : Condition {
        override fun isSuitable(person: Person): Boolean {
            return person.age < 30
        }
    })
    for (profile in filterd){
        println(profile)
    }
}

fun filter(profiles: List<Person>, condition: Condition): List<Person>{
    val newProfiles = mutableListOf<Person>()
    for (person in profiles){
        if (condition.isSuitable(person)){
            newProfiles.add(person)
        }
    }
    return newProfiles
}

