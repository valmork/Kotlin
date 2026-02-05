package corporation

import java.io.File

object WorkersRepository {

    private val fileWorkers = File("workers.txt")
    private val _workers = loadAllEmployees()
    val workers
        get() = _workers.toList()

    fun registerNewEmployee(newWorker: Worker){
        _workers.add(newWorker)
    }

    fun findAssistant(): Assistant?{
        for (worker in _workers){
            if (worker is Assistant){
                return worker
            }
        }
        return null
    }

    fun findDirector(): Director?{
        for (worker in _workers){
            if (worker is Director){
                return worker
            }
        }
        return null
    }

    fun changeSalary(id: Int, salary: Int){
        for (worker in _workers){
            if (id == worker.id){
                val newWorker = worker.copy(salary = salary)
                _workers.remove(worker)
                _workers.add(newWorker)
                break
            }
        }
    }

    fun changeAge(id: Int, age: Int){
        for (worker in _workers){
            if (id == worker.id){
                val newWorker = worker.copy(age = age)
                _workers.remove(worker)
                _workers.add(newWorker)
                break
            }
        }
    }

    fun saveChanges(){
        val content = StringBuilder()
        for (worker in _workers){
            content.append("${worker.id}%${worker.name}%${worker.age}%${worker.salary}%${worker.position}\n")
        }
        fileWorkers.writeText(content.toString())
    }

    private fun loadAllEmployees(): MutableSet<Worker>{
        val employees = mutableSetOf<Worker>()

        if (!fileWorkers.exists()) fileWorkers.createNewFile()

        val content = fileWorkers.readText().trim()

        if (content.isEmpty()) return employees

        val employeesAsText = content.split("\n")
        for (employeeAsText in employeesAsText){
            val propetries = employeeAsText.split("%")
            val id = propetries[0].toInt()
            val name = propetries[1]
            val age = propetries[2].toInt()
            val salary = propetries[3].toInt()
            val positionAsText = propetries.last()
            val position = Position.valueOf(positionAsText)
            val worker = when(position){
                Position.DIRECTOR -> Director(id, name, age, salary)
                Position.ACCOUNTANT -> Accountant(id, name, age, salary)
                Position.ASSISTANT -> Assistant(id, name, age, salary)
                Position.CONSULTANT -> Consultant(id, name, age, salary)
            }
            employees.add(worker)
        }
        return employees
    }

    fun fireEmployee(id: Int){
        for (worker in _workers){
            if (id != worker.id){
                _workers.remove(worker)
                break
            }
        }
    }
}