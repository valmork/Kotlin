package corporation

import java.io.File

class WorkersRepository {

    val fileWorkers = File("workers.txt")

    fun registerNewEmployee(worker: Worker){
        saveWorkerToFile(worker)
    }

    fun changeSalary(id: Int, salary: Int){
        val employees = loadAllEmployees()
        fileWorkers.writeText("")

        for (employee in employees){
            if (id == employee.id){
                employee.setSalary(salary)
            }
            saveWorkerToFile(employee)
        }
    }

    private fun saveWorkerToFile(worker: Worker){
        fileWorkers.appendText("${worker.id}%${worker.name}%${worker.age}%${worker.getSalary()}%${worker.position}\n")
    }

    fun loadAllEmployees(): MutableList<Worker>{
        val employees = mutableListOf<Worker>()

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
        val employees = loadAllEmployees()
        fileWorkers.writeText("")

        for (employee in employees){
            if (id != employee.id){
                saveWorkerToFile(employee)
            }
        }
        fileWorkers.writeText("")
    }
}