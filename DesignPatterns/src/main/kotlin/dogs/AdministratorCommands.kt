package dogs

import command.Command

sealed interface AdministratorCommands: Command {

    data class AddDog(
        val repository: DogsRepository,
        val dogBreed: String,
        val dogName: String,
        val dogWeight: Double
    ): AdministratorCommands{

        override fun execute() {
            repository.addDog(dogBreed, dogName, dogWeight)
        }
    }

    data class DeleteDog(
        val repository: DogsRepository,
        val dogId: Int
    ): AdministratorCommands{

        override fun execute() {
            repository.deleteDog(dogId)
        }
    }

    data class SaveChanges(
        val repository: DogsRepository
    ): AdministratorCommands{

        override fun execute() {
            repository.saveChanges()
        }
    }
}