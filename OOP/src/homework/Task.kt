package homework

fun task(listUser: List<String>) : List<String> {
    val operationOptions = OperationOptions.entries
    val mutableListUsers = listUser.toMutableList()
    print("Выберите действие. ")
    for ((index, option) in operationOptions.withIndex()){
        print("$index - ${option.title}")
        if (index < operationOptions.size - 1){
            print(", ")
        }else{
            print(": ")
        }
    }

    val choice = readln().toInt()
    val operationOptionsChoice: OperationOptions = operationOptions[choice]
    when(operationOptionsChoice){
        OperationOptions.SHOW -> {
            for (user in mutableListUsers){
                println(user)
            }
        }
        OperationOptions.ADD -> {
            val newUser = readln()
            mutableListUsers.add(newUser)
            for (user in mutableListUsers){
                println(user)
            }
        }
        OperationOptions.REMOVE -> {
            val userToRemove = readln()
            if (mutableListUsers.remove(userToRemove)){
                mutableListUsers.remove(userToRemove)
                for (user in mutableListUsers){
                    println(user)
                }
            }else{
                for (user in mutableListUsers){
                    println(user)
                }
            }
        }
        OperationOptions.REMOVE_AT -> {
            val indexUserToRemove = readln().toInt()
            mutableListUsers.removeAt(indexUserToRemove)
            for (user in mutableListUsers){
                println(user)
            }
        }
        else -> println("Некорректное значение")
    }
    val users = mutableListUsers.toList()
    return users
}

