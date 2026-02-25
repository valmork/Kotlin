package dogs

class Administrator {

    private val dogRepository = DogsRepository.Companion.getInstance("dogs")

    fun work(){
        println("Creating repository...")

        val operationCodes = dogs.Operation.entries
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
                    dogRepository.saveChanges()
                    break
                }
                Operation.ADD_DOG -> addDog()
                Operation.DELETE_DOG -> deleteDog()
            }
        }
    }


    private fun addDog(){
        print("Enter breed: ")
        val dogBreed = readln()
        print("Enter  name: ")
        val dogName = readln()
        print("Enter weight: ")
        val dogWeight = readln().toDouble()
        dogRepository.addDog(dogBreed, dogName, dogWeight)
    }

    private fun deleteDog(){
        print("Enter id: ")
        val id = readln().toInt()
        dogRepository.deleteDog(id)
    }
}