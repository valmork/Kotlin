package dogs

import kotlinx.serialization.json.Json
import observer.Observable
import observer.Observer
import java.io.File
import kotlin.collections.last

class DogsRepository private constructor(): Observable<List<Dog>>{

    private val file = File("dogs.json")

    private val _dogs = loadAllDogs()
    override val currentValue: List<Dog>
        get() = _dogs.toList()

    private val _observers = mutableListOf<Observer<List<Dog>>>()
    override val observers
        get() = _observers.toList()

    override fun registerObserver(observer: Observer<List<Dog>>) {
        _observers.add(observer)
        observer.onChanged(currentValue)
    }

    override fun unregisterObserver(observer: Observer<List<Dog>>) {
        _observers.remove(observer)
    }

    private fun loadAllDogs(): MutableList<Dog>{
        return Json.decodeFromString(file.readText().trim())
    }

    fun addDog(dogBreed: String, dogName: String, dogWeight: Double){
        val id = currentValue.last().dogId + 1
        _dogs.add(Dog(dogBreed, id, dogName, dogWeight))
        notifyObservers()
    }

    fun deleteDog(id: Int){
        _dogs.removeIf { it.dogId == id }
        notifyObservers()
    }

    fun saveChanges(){
        val content = Json.encodeToString(_dogs)
        file.writeText(content)
    }

    fun addOnDogsChangedListener(observer: Observer<List<Dog>>){
        registerObserver(observer)
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