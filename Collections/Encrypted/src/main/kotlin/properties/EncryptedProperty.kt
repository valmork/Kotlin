package properties

import kotlin.io.encoding.Base64
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// Internal позволяет работать в рамках одного модуля. В Java internal меняется на public.
// Extension функции в Java меняются на простые функции с параметрами.

fun encrypted() = EncryptedProperty()

class EncryptedProperty internal constructor (): ReadWriteProperty<Any, String> {

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

fun String.encode(): String {
    return Base64.encode(this.toByteArray())
}