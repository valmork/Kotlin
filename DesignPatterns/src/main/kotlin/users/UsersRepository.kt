package users

import kotlinx.serialization.json.Json
import observer.MutableObservable
import observer.Observable
import java.io.File

class UsersRepository private constructor() {

    private val file = File("users.json")

    private val userList: MutableList<User> = loadAllUsers()

    private val _users = MutableObservable(userList.toList())
    val users: Observable<List<User>>
        get() = _users

    private val _oldestUser = MutableObservable(userList.maxBy { it.age })
    val oldestUser
        get() = _oldestUser

    private fun loadAllUsers(): MutableList<User> = Json.decodeFromString(file.readText().trim())

    fun addUser(firstName: String, lastName: String, age: Int){
        val id = userList.last().userId + 1
        val user = User(userId = id, age = age, firstName = firstName, lastName = lastName, email = "email", gender = "gender")
        userList.add(user)
        _users.currentValue = userList.toList()
        if (age > oldestUser.currentValue.age){
            oldestUser.currentValue = user
        }
    }

    fun deleteUser(id: Int){
        userList.removeIf { it.userId == id }
        _users.currentValue = userList.toList()
        if (id == oldestUser.currentValue.userId){
            oldestUser.currentValue = userList.maxBy { it.age }
        }
    }

    fun saveChanges(){
        val content = Json.encodeToString(userList)
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