package corporation

enum class OperationCode(val title: String) {
    EXIT(title = "Выйти"),
    REGISTER_NEW_ITEM(title = "Зарегистрироваться"),
    SHOW_ALL_ITEMS(title = "Показать все карточки"),
    REMOVE_PRODUCT_CARD(title = "Удалить продукт"),
    REGISTER_NEW_EMPLOYEE(title = "Зарегистрировать нового сторудника"),
    FIRE_EMPLOYEE(title = "Уволить сотрудника"),
    SHOW_ALL_EMPLOYEES(title = "Показать всех сотрудников")
}