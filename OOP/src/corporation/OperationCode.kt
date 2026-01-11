package corporation

enum class OperationCode(val title: String) {
    EXIT(title = "Выйти"),
    REGISTER_NEW_ITEM(title = "Зарегистрироваться"),
    SHOW_ALL_ITEMS(title = "Показать все карточки"),
    REMOVE_PRODUCT_CARD(title = "Удалить продукт")
}