package users

class Administrator {

    private val usersRepository = UsersRepository.getInstance("qwerty")

    fun work(){
        println("Creating repository...")

        val operationCodes = Operation.entries
        while (true) {
            print("Enter an operation: ")
            for ((index,code) in operationCodes.withIndex()){
                print("$index - ${code.title}")
                if (index < operationCodes.size - 1){
                    print(", ")
                }else print(". ")
            }

            val choice = readln().toInt()
            val operationCodeChoice = operationCodes[choice]

            when (operationCodeChoice){
                Operation.EXIT -> {
                    usersRepository.saveChanges()
                    break
                }
                Operation.ADD_USER -> addUser()
                Operation.DELETE_USER -> deleteUser()
            }
        }
    }


    private fun addUser(){
        print("Enter firstname: ")
        val firstName = readln()
        print("Enter lastname: ")
        val lastName = readln()
        print("Enter age: ")
        val age = readln().toInt()
        usersRepository.addUser(firstName, lastName, age)
    }

    private fun deleteUser(){
        print("Enter id: ")
        val id = readln().toInt()
        usersRepository.deleteUser(id)
    }
}