package inline

fun main() {
    val user = User(UserId(0), "Anton")
    user.id.showValue()
}

data class User(val id: UserId, val name: String)

@JvmInline
value class UserId(val value: Int) {

    fun  showValue() {
        println(value)
    }
}