package dogs


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dog(
    @SerialName("dog_breed")
    val dogBreed: String,
    @SerialName("dog_id")
    val dogId: Long,
    @SerialName("dog_name")
    val dogName: String,
    @SerialName("dog_weight")
    val dogWeight: Double
)