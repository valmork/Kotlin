package users

import kotlinx.serialization.json.Json
import observer.Observer
import java.io.File

class UsersRepository private constructor() {

    private val file = File("users.json")

    private val _users: MutableList<User> = loadAllUsers()
    val users
        get() = _users.toList()

    private val observers = mutableListOf<Observer<List<User>>>()

    private fun loadAllUsers(): MutableList<User> = Json.decodeFromString(file.readText().trim())

    private fun notifyObservers(){
        for (observer in observers){
            observer.onChanged(users)
        }
    }

    fun addOnUsersChangedListener(observer: Observer<List<User>>) {
        observers.add(observer)
        observer.onChanged(users)
    }

    fun addUser(firstName: String, lastName: String, age: Int){
        val id = users.last().userId + 1
        _users.add(User(userId = id, age = age, firstName = firstName, lastName = lastName, email = "email", gender = "gender"))
        notifyObservers()
    }

    fun deleteUser(id: Int){
        _users.removeIf { it.userId == id }
        notifyObservers()
    }

    fun saveChanges(){
        val content = Json.encodeToString(_users)
        file.writeText(content)
    }

    companion object {

        private val lock = Any()
        private  var instance: UsersRepository? = null

        fun getInstance(password: String): UsersRepository{
            val correctPassword = File("password_users.txt").readText().trim()
            if (correctPassword != password) throw IllegalArgumentException("Wrong password")
            instance?.let { return it }
            synchronized(lock) {
                instance?.let { return it }

                return UsersRepository().also { instance = it }
            }
        }
    }
}