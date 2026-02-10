package profile

import kotlinx.serialization.json.Json
import java.io.File

fun main() {
    val profiles = ProfilesRepository.profiles
    for (person in profiles){
        println(person)
    }
}
