package users

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class User(
    @SerialName("user_id")
    val userId: Int,
    @SerialName("age")
    val age: Int,
    @SerialName("email")
    val email: String,
    @SerialName("first_name")
    val firstName: String,
    @SerialName("gender")
    val gender: String,
    @SerialName("last_name")
    val lastName: String
)