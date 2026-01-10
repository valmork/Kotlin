package files

import java.io.File

fun main(){
    val file = File("toDoList.txt")
    val operationEntries = OperationCode.entries
    var isExit: Boolean = false
    while (!isExit){
        print("Введите ваш выбор. ")
        for ((index, code) in operationEntries.withIndex()) {
            print("$index - ${code.title}")
            if (index < operationEntries.size - 1) {
                print(", ")
            } else {
                print(": ")
            }
        }
        val operationChoice = readln().toInt()
        val operationCodeChoice: OperationCode = operationEntries[operationChoice]
        when (operationCodeChoice) {
            OperationCode.REGISTER_NEW_ITEM -> {
                print("Введите ваше дело: ")
                val case = readln()
                file.appendText(case + "\n")
            }
            OperationCode.SHOW_ALL_ITEMS -> {
                val content = file.readText().trim()
                val items = content.split("\n")
                for ((index, item) in items.withIndex()){
                    println("$index - $item")
                }
            }
            OperationCode.EXIT -> {
                isExit = true
            }
        }
    }
}

