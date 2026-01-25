package homework

class PasswordHasher {
    fun hashPassword(password: String): String {
        return password.reversed() // Простая симуляция хеширования (не использовать в продакшене)
    }
}