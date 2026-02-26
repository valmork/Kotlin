import kotlin.math.round

fun interface Observer<T>{
    fun onChanged(newValue: T)
}

interface Observable<T> {
    val currentValue: T
    val observers: List<Observer<T>>

    fun registerObserver(observer: Observer<T>)

    fun unregisterObserver(observer: Observer<T>)

    fun notifyObservers(){
        for (observer in observers){
            observer.onChanged(currentValue)
        }
    }
}

class MutableObservable<T>(initialValue: T) : Observable<T>{
    override var currentValue: T = initialValue
        set(value) {
            field = value
            notifyObservers()
        }
    private val _observers = mutableListOf<Observer<T>>()
    override val observers: List<Observer<T>>
        get() = _observers.toList()

    override fun registerObserver(observer: Observer<T>) {
        _observers.add(observer)
        observer.onChanged(currentValue)
    }

    override fun unregisterObserver(observer: Observer<T>) {
        _observers.remove(observer)
    }
}


// Репозиторий данных
object DataRepository {
//    var userData: String = "User_Initial"
    var userData = MutableObservable("User_Initial")
//    var orderData: Int = 100
    var orderData = MutableObservable(100)
//    var priceData: Double = 99.99
    var priceData = MutableObservable(99.99)

    // Метод обновления данных
    fun updateData(newUser: String? = null, newOrder: Int? = null, newPrice: Double? = null) {
        newUser?.let { userData.currentValue = it }
        newOrder?.let { orderData.currentValue = it }
        newPrice?.let { priceData.currentValue = round(it * 100) / 100 }
    }
}


// Мониторинг данных с периодическим опросом
class UserMonitor(private val repository: DataRepository) {
    init {
        repository.userData.registerObserver { newValue ->
            println("UserMonitor: Обнаружено изменение данных пользователя: $newValue")
        }

    }
}

class OrderMonitor(private val repository: DataRepository) {
    init {
        repository.orderData.registerObserver { newValue ->
            println("OrderMonitor: Обнаружено изменение данных заказа: $newValue")
        }

    }
}

class PriceMonitor(private val repository: DataRepository) {
    init {
        repository.priceData.registerObserver { newValue ->
            println("PriceMonitor: Обнаружено изменение цены: $newValue")
        }

    }
}