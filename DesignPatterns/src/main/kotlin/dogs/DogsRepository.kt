package dogs

import kotlinx.serialization.json.Json
import java.io.File

class DogsRepository private constructor(){


    private fun loadAllDogs(): MutableList<Dog>{
        return Json.decodeFromString(file.readText().trim())
    }

    private val file = File("dogs.json")

    private val _dogs = loadAllDogs()
    val dogs
        get() = _dogs.toList()

    companion object{
        private  var instance: DogsRepository? = null

        fun getInstance(password: String): DogsRepository{
            val correctPassword = File("password_dogs.txt").readText().trim()
            if (correctPassword != password) throw IllegalArgumentException("Wrong password")
            if (instance == null){
                instance = DogsRepository()
            }
            return instance!!
        }
    }
}