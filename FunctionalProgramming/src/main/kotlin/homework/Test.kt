package homework

fun main() {
    processStrings(listOf(" ","hello","world" ,"test","hello"," "))
}
/**
 * Обрабатывает коллекцию строк с использованием цепочки преобразований.
 * @param strings Коллекция строк для обработки.
 * @return Преобразованная коллекция строк.
 */
fun processStrings(strings: List<String>): List<String> {
    return strings.also {
        println("Исходный список: $strings")
    }.filter { it.isNotBlank() }.also {
        println("Этап 1: Осталось ${it.count()} непустых строк")
    }               // Убираем пустые строки
        .map { it.trim() }                       // Убираем лишние пробелы
        .filter { it.length > 3 }.also {
            println("Этап 2: Строки длиной более 3 символов: $it")
        }                  // Оставляем строки длиной больше 3
        .sortedBy { it.length }.also {
            println("Этап 3: Первые 3 строки после сортировки: ${it.take(3)}")
        }                   // Сортируем по длине
        .map { it.uppercase() }.also {
            println("Этап 4: Все строки в верхнем регистре: $it")
        }                   // Преобразуем в верхний регистр
        .distinct()                               // Убираем дубликаты
        .take(5).also {
            println("Этап 5: Итоговый результат: $it")
        }                                  // Берём первые 5 строк
}