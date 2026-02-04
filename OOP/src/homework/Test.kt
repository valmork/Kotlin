package homework

fun main() {

    val user1 = User(1, "Anton", "")
    val user2 = User(1, "", "")
    println(user1.hashCode())
    println(user2.hashCode())
}