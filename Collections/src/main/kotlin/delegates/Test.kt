package delegates

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

fun encrypted() = EncryptedProperty()

class EncryptedProperty(): ReadWriteProperty<Any, String> {

    private var encryptedValue: String = ""

    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        println("Getting value, encoded: $encryptedValue")
        val decoded = String(Base64.decode(encryptedValue))
        println("Getting value, decoded: $decoded")
        return decoded
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        println("New value: $value")
        val encoded = Base64.encode(value.toByteArray())
        println("Encoded value: $encoded")
        encryptedValue = encoded
    }
}