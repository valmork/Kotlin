package homework

class Config {

    var timeout: Int = 30
        set(value) {
            if (value !in 1..300){
                field = field
                println("Ошибка: Время ожидания должно быть в диапазоне от 1 до 300 секунд. " +
                        "Установлено значение по умолчанию.")
            } else{
                field = value
            }
        }

    var maxRetries: Int = 3
        set(value) {
            if (value < 0){
                field = field
                println("Ошибка: Максимальное количество повторных попыток не может быть отрицательным. " +
                        "Установлено значение по умолчанию.")
            } else{
                field = value
            }
        }

    var loggingLevel: LogLevel = LogLevel.INFO
        set(value) {
            if (value == LogLevel.TRACE || value == LogLevel.FATAL){
                println("Ошибка: Уровень $value недоступен.")
            }else{
                field = value
            }
        }

    val isDebugMode: Boolean
        get() {
            if (loggingLevel == LogLevel.DEBUG){
                return true
            }else{
                return false
            }
        }

    val isProductionMode: Boolean
        get() {
            if (loggingLevel == LogLevel.ERROR){
                return true
            }else{
                return false
            }
        }

    fun printConfig(){
        println("Время ожидания: $timeout секунд\n" +
                "Максимальное количество повторных попыток: $maxRetries\n" +
                "Уровень логирования: $loggingLevel\n" +
                "Режим отладки: $isDebugMode\n" +
                "Режим продакшн: $isProductionMode")
    }
}