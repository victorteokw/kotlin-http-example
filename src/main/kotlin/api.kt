import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString

enum class Sex(val value: String) {
    MALE("MALE"),
    FEMALE("FEMALE")
}

@Serializable
data class User(
    val id: String,
    val email: String? = null,
    val phoneNumber: String? = null,
    val callingCode: String? = null,
    val sex: Sex? = null,
    val createdAt: String,
    val updatedAt: String
)

@Serializable
data class UserCreateInput(
    val email: String? = null,
    val phoneNumber: String? = null,
    val callingCode: String? = null,
    val password: String,
    val authenticationCode: String? = null,
    val oldPassword: String? = null,
    val name: String? = null,
    val sex: Sex? = null
)

@Serializable
data class UserUpdateInput(
    val email: String? = null,
    val phoneNumber: String? = null,
    val callingCode: String? = null,
    val password: String? = null,
    val authenticationCode: String? = null,
    val oldPassword: String? = null,
    val name: String? = null,
    val sex: Sex? = null
)

fun main() {
    // Json Serialization
    val obj = Json.decodeFromString<UserUpdateInput>("""{"email": "ben.wong@fillmula.com", "password": "Aa12345$"}""")
    val update = UserUpdateInput(email="lucy.liu@fillmula.com", sex=Sex.FEMALE)
    val str = Json.encodeToString(update)
    println(obj)
    println(str)
}
