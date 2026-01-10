package files

enum class OperationCode(val title: String) {
    EXIT(title = "Выйти"), REGISTER_NEW_ITEM(title = "Добавить дело"), SHOW_ALL_ITEMS(title = "Показать все дела")
}