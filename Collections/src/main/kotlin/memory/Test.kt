package memory

data class User(val name: String)

fun main() {
    val users = mutableListOf<User>()
    repeat(1_000_000_000) {
        users.add(User("$it"))
    }
    println("Finished")
}