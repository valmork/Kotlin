package homework

abstract class DataProcessor(
    val processorName: String
) {
    fun process(data: String): String{
        return "Обработчик: $processorName обработал данные"
    }
}