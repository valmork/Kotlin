package dogs

import kotlinx.serialization.json.Json
import observer.MutableObservable
import observer.Observable
import java.io.File
import kotlin.collections.last

class DogsRepository private constructor(){

    private val file = File("dogs.json")

    private val dogsList = loadAllDogs()

    private val _dogs = MutableObservable(dogsList.toList())
    val dogs: Observable<List<Dog>>
        get() = _dogs


    private fun loadAllDogs(): MutableList<Dog>{
        return Json.decodeFromString(file.readText().trim())
    }

    fun addDog(dogBreed: String, dogName: String, dogWeight: Double){
        val id = dogsList.last().dogId + 1
        dogsList.add(Dog(dogBreed, id, dogName, dogWeight))
        _dogs.currentValue = dogsList.toList()

    }

    fun deleteDog(id: Int){
        dogsList.removeIf { it.dogId == id }
        _dogs.currentValue = dogsList.toList()
    }

    fun saveChanges(){
        val content = Json.encodeToString(dogsList)
        file.writeText(content)
    }


    companion object{

        private val lock = Any()
        private  var instance: DogsRepository? = null

        fun getInstance(password: String): DogsRepository{
            val correctPassword = File("password_dogs.txt").readText().trim()
            if (correctPassword != password) throw IllegalArgumentException("Wrong password")
            instance?.let { return it }

            synchronized(lock) {
                instance?.let { return it }

                return DogsRepository().also { instance = it }
            }
        }
    }
}