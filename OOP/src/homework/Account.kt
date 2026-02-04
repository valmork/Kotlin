package homework

class Account(
    val accountId: String,
    val userId: Int,
    val email: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Account) return false
        return this.accountId == other.accountId && this.email == other.email
    }

    override fun hashCode(): Int {
        var result = accountId.hashCode()
        result = 31 * result + email.hashCode()
        return result
    }
}