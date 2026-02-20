package dictionary

import kotlinx.serialization.json.Json
import java.io.File

fun main() {
    val file = File("dictionary.json")
    val content = file.readText().trim()
    val dictionary = Json.decodeFromString<List<Entry>>(content)
    showDescription(dictionary)
}

fun showDescription(dictionary: List<Entry>){
    while (true){
        print("Enter your word or 0 to exit: ")
        val input = readln().lowercase()
        if (input == "0") break
        dictionary.find { it.value == input }?.let { println(it.description) } ?: println("Not found")
    }
}