package test

import kotlinx.serialization.json.Json
import java.io.File

fun main() {
    val file = File("books.json")
    writeToFile(file)
    val books = readFromFile(file)
    for (book in books){
        println(book)
    }
}

fun readFromFile(file: File): List<Book> {
    val content = file.readText().trim()
    return Json.decodeFromString<List<Book>>(content)
}

fun writeToFile(file: File){
    val books = mutableListOf<Book>()
    while (true){
        print("Enter name or 0 to exit: ")
        val name = readln()
        if (name == "0") break
        print("Enter author`s name: ")
        val authorName = readln()
        print("Enter year: ")
        val year = readln().toInt()
        val book = Book(name, authorName, year)
        books.add(book)
    }
        val booksAsString = Json.encodeToString(books)
        file.writeText(booksAsString)
}