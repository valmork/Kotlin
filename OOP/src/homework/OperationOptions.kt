package homework

enum class OperationOptions(val title: String) {
    SHOW(title = "Показать список"),
    ADD(title = "Добавить в список"),
    REMOVE(title = "Удалить по названию"),
    REMOVE_AT(title = "Удалить по индексу")
}