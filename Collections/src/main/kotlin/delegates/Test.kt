package delegates

import properties.encrypted
import kotlin.io.encoding.Base64
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main() {
    val user = User()
    user.password = "123"
}

class User() {

    var a by observable(0) {old: Int, new: Int ->
        println("Old value: $old New value: $new")
    }

    var password: String by encrypted()

    var credCardNumber: String by encrypted()
}

fun <T> observable(
    initialValue: T,
    onChanged: (oldValue: T, newValue: T) -> Unit
) = ObservableProperty<T>(initialValue, onChanged)

class ObservableProperty<T> (
    initialValue: T,
    private val onChanged: (oldValue: T, newValue: T) -> Unit
): ReadWriteProperty<Any, T> {

    private var currentValue: T = initialValue

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        return currentValue
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        val oldValue = currentValue
        currentValue = value
        onChanged(oldValue, value)
    }
}