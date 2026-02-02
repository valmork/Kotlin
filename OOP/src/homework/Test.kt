package homework

fun main() {

    val employee = Employee(1, "Алексей")
    val task = Task(1, "Создание макета", "Создать макет страницы", "Алексей", "Назначена", "Высокий")

    employee.addTask(task)

    println(employee.tasks[0].title)
    println(employee.tasks[0].description)

    employee.modifyTaskDetails(1, "Обновленный макет", "Создать новый макет страницы")

    println(employee.tasks[0].title)
    println(employee.tasks[0].description)
}