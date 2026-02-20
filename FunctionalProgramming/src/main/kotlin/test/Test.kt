package test

import kotlinx.serialization.json.Json
import java.io.File
import java.util.Dictionary

fun main() {
    val dictionary = mutableMapOf<String, String>(
    )
    dictionary["Anton"] = "89290619465"
    dictionary["Mom"] = "89202835476"

    print("Enter your name and phone number (use spaces): ")
    val input = readln()
    val entries = input.split(" ")
    dictionary[entries[0]] = entries[1]
    println(dictionary)
    addPerson(dictionary)

}

fun addPerson(dictionary: Map<String, String>){
    while (true) {
        print("Enter name or 0 to exit: ")
        val input = readln()
        if (input == "0") break
        val numbers = dictionary.values
        println(dictionary[input] ?: "Not found")

        //еще одна реализация
//        for (name in dictionary.keys){
//            if (input == name){
//                println(dictionary[input])
//                break
//            }
//
//        }
//        if (!dictionary.keys.contains(input)){
//            println("Number not found")
//        }
    }
}