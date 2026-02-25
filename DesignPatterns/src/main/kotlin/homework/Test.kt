// Хранилище пользователей
class UserRepository {
    private val users = mutableListOf<String>()

    private val observers = mutableListOf<UserLogger>()

    fun addUser(user: String) {
        users.add(user)
        notifyObservers()
    }

    fun removeUser(user: String) {
        users.remove(user)
        notifyObservers()
    }

    fun subscribe(logger: UserLogger){
        observers.add(logger)
        logger.onUsersChanged(users)
    }

    fun unsubscribe(logger: UserLogger){
        observers.remove(logger)
    }

    fun notifyObservers(){
        for (observer in observers){
            observer.onUsersChanged(users)
        }
    }
}

// Класс наблюдателя, который подписывается на изменения в UserRepository
class UserLogger {
    // [LOG] Пользователи обновлены: <список пользователей>
    fun onUsersChanged(users: List<String>){
        println("[LOG] Пользователи обновлены: $users")
    }
}