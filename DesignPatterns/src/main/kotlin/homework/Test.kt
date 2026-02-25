// Ваша задача — сделать этот класс Singleton
class SettingsManager private constructor (context: Context) : BaseManager(context) {

    private val _settings: MutableMap<String, String> = mutableMapOf()
    val settings
        get() = _settings.toMap()


    init {
        _settings.putAll(context.defaultSettings)
    }

    fun getSetting(key: String): String? {
        return _settings[key]
    }

    companion object{
        private var instance: SettingsManager? = null

        fun getInstance(context: Context): SettingsManager = instance ?: SettingsManager(context).also { instance = it }
        }
    }


open class BaseManager(val context: Context)

data class Context(val name: String, val defaultSettings: Map<String, String>)