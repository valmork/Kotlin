package profile

import extensions.myForEach

fun main() {
    ProfilesRepository.profiles.showEmail()
}

fun filterCollection(){
    ProfilesRepository.profiles
        .filter { person: Person -> person.age > 25 }
        .filter { it.gender == Gender.MALE }
        .filter { it.firstName.startsWith("A") }
        .filter { it.age < 30 }
        .sortedBy { it.firstName }
        .forEach { println(it) }
}

fun List<Person>.showEmail(){
    val id = readln().toInt()
    this.find { it.id == id  }?.let { println("Email человека с ID-$id равен ${it.email}") } ?: println("Не найдено")
}



