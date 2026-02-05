package corporation

data class Accountant(
    override val id: Int,
    override val name: String,
    override val age: Int,
    override val salary: Int
): Worker(
    id = id,
    name = name,
    age = age,
    salary = salary,
    position = Position.ACCOUNTANT
), Cleaner, Supplier {

    private val workersRepository = WorkersRepository
    private val productCardsRepository = ProductCardsRepository

    override fun buyThings() {
        println("My position is accountant. I am buying something...")
    }

    override fun clean() {
        println("My position is accountant. I am cleaning my workplace")
    }

    override fun copy(
        id: Int,
        name: String,
        salary: Int,
        age: Int,
        position: Position
    ): Worker {
        return copy(id = id, name = name, age = age, salary = salary)
    }

    override fun work() {
        var isExit: Boolean = false
        val operationCodeTypes = OperationCode.entries
        while (!isExit){
            println("Enter the operation code.")
            for ((index, code) in operationCodeTypes.withIndex()) {
                print("$index - ${code.title}\n")
            }
            val choice = readln().toInt()
            val operationCodeChoice: OperationCode = operationCodeTypes[choice]
            when (operationCodeChoice){
                OperationCode.EXIT -> {
                    workersRepository.saveChanges()
                    productCardsRepository.saveChanges()
                    isExit = true
                }
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
                OperationCode.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                OperationCode.FIRE_EMPLOYEE -> fireEmployee()
                OperationCode.SHOW_ALL_EMPLOYEES -> showAllEmployees()
                OperationCode.CHANGE_SALARY -> changeSalary()
                OperationCode.CHANGE_AGE -> changeAge()
                else -> println("Incorrect input")
            }
        }
    }

    private fun changeAge(){
        print("Enter employee's id to change age: ")
        val id = readln().toInt()
        print("Enter new age: ")
        val age = readln().toInt()
        workersRepository.changeAge(id, age)
    }

    private fun changeSalary(){
        print("Enter employee's id to change salary: ")
        val id = readln().toInt()
        print("Enter new salary: ")
        val salary = readln().toInt()
        workersRepository.changeSalary(id, salary)
    }

    fun registerNewEmployee(){
        val positions = Position.entries
        print("Choose position - ")
        for ((index, position) in positions.withIndex()){
            print("$index - ${position.title}")
            if (index < positions.size - 1){
                print(", ")
            } else{
                print(": ")
            }
        }
        val positionIndex = readln().toInt()
        val position = positions[positionIndex]
        print("Enter id: ")
        val id = readln().toInt()
        print("Enter name: ")
        val name = readln()
        print("Enter age: ")
        val age = readln().toInt()
        print("Enter salary: ")
        val salary = readln().toInt()
        val worker = when(position){
            Position.DIRECTOR -> Director(id, name, age, salary)
            Position.ACCOUNTANT -> Accountant(id, name, age, salary)
            Position.ASSISTANT -> Assistant(id, name, age, salary)
            Position.CONSULTANT -> Consultant(id, name, age, salary)
        }
        workersRepository.registerNewEmployee(worker)
    }

    fun fireEmployee(){
        print("Enter employee's id to fire")
        val id = readln().toInt()
        workersRepository.fireEmployee(id)
    }

    fun showAllEmployees(){
        val employees = workersRepository.workers
        for (employee in employees){
            employee.printInfo()
        }
    }



    fun showAllItems(){
        val cards = productCardsRepository.productCards

        if (cards.isEmpty()){
            println("No product cards available")
            return
        }

        for (card in cards){
            card.printInfo()
        }
    }

    fun removeProductCard(){
        print("Enter name of card for removing: ")
        val name = readln()
        productCardsRepository.removeProductCard(name)
    }

    fun registerNewItem(){
        val productTypes = ProductType.entries
        print("Enter the product type. ")
        for ((index, type) in productTypes.withIndex()){
            print("$index - ${type.title}")
            if (index < productTypes.size - 1){
                print(", ")
            }
            else{
                print(": ")
            }
        }
//        print(" 0 - ${productTypes[0].title}, 1 - ${productTypes[1].title}, 2 - ${productTypes[2].title}: ")
        val productTypeIndex = readln().toInt()
        val productChoice: ProductType = productTypes[productTypeIndex]
        print("Enter name: ")
        val name = readln()
        print("Enter brand: ")
        val brand = readln()
        print("Enter price: ")
        val price = readln().toInt()
        val card = when (productChoice){
            ProductType.FOOD -> {
                print("Enter caloric: ")
                val caloric = readln().toInt()
                FoodCard(name, brand, price, caloric)
            }
            ProductType.APPLIANCE -> {
                print("Enter wattage: ")
                val wattage = readln().toInt()
                ApplianceCard(name, brand, price, wattage)
            }
            ProductType.SHOE -> {
                print("Enter size: ")
                val size = readln().toFloat()
                ShoeCard(name, brand, price, size)
            }
        }
        productCardsRepository.registerNewItem(card)
    }
}