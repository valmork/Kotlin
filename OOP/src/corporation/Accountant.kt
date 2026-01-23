package corporation

import java.io.File
import java.sql.SQLOutput

class Accountant(
    id: Int,
    name: String,
    age: Int
): Worker(id, name, age, Position.ACCOUNTANT), Cleaner, Supplier {

    val fileProductCards = File("product_cards.txt")
    val fileWorkers = File("workers.txt")

    override fun buyThings() {
        println("My position is accountant. I am buying something...")
    }

    override fun clean() {
        println("My position is accountant. I am cleaning my workplace")
    }


    override fun work() {
        var isExit: Boolean = false
        val operationCodeTypes = OperationCode.entries
        while (!isExit){
            println("Enter the operation code.")
            for ((index, code) in operationCodeTypes.withIndex()) {
                print("$index - ${code.title}\n")
            }
            print("Enter the operation code. 0 - exit, 1 - register new item: ")
            val choice = readln().toInt()
            val operationCodeChoice: OperationCode = operationCodeTypes[choice]
            when (operationCodeChoice){
                OperationCode.EXIT -> isExit = true
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                OperationCode.REMOVE_PRODUCT_CARD -> removeProductCard()
                OperationCode.REGISTER_NEW_EMPLOYEE -> registerNewEmployee()
                OperationCode.FIRE_EMPLOYEE -> fireEmployee()
                OperationCode.SHOW_ALL_EMPLOYEES -> showAllEmployees()
                else -> println("Incorrect input")
            }
        }
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
        val worker = when(position){
            Position.DIRECTOR -> Director(id, name, age)
            Position.ACCOUNTANT -> Accountant(id, name, age)
            Position.ASSISTANT -> Assistant(id, name, age)
            Position.CONSULTANT -> Consultant(id, name, age)
        }
        saveWorkerToFile(worker)
    }

    fun fireEmployee(){
        print("Enter employee's id to fire")
        val id = readln().toInt()
        val employees = loadAllEmployees()
        fileWorkers.writeText("")

        for (employee in employees){
            if (id != employee.id){
                saveWorkerToFile(employee)
            }
        }
        fileWorkers.writeText("")

    }

    fun showAllEmployees(){
        val employees = loadAllEmployees()
        for (employee in employees){
            employee.printInfo()
        }
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
            val positionAsText = propetries.last()
            val position = Position.valueOf(positionAsText)
            val worker = when(position){
                Position.DIRECTOR -> Director(id, name, age)
                Position.ACCOUNTANT -> Accountant(id, name, age)
                Position.ASSISTANT -> Assistant(id, name, age)
                Position.CONSULTANT -> Consultant(id, name, age)
            }
            employees.add(worker)
        }
        return employees
    }

    fun saveWorkerToFile(worker: Worker){
        fileWorkers.appendText("${worker.id}%${worker.name}%${worker.age}%${worker.position}\n")
    }

    fun loadAllCards(): MutableList<ProductCard> {
        val cards: MutableList<ProductCard> = mutableListOf<ProductCard>()

        if (!fileProductCards.exists()) fileProductCards.createNewFile()
        val content = fileProductCards.readText().trim()

        if (content.isEmpty()){
            return cards
        }

        val cardsAsString = content.split("\n")
        for (cardString in cardsAsString){
            val contentItems = cardString.split("%")
            val name = contentItems[0]
            val brand = contentItems[1]
            val price = contentItems[2].toInt()
            val type = contentItems.last()
            val productType = ProductType.valueOf(type)
            val productCard = when (productType){
                ProductType.FOOD -> {
                    val caloric = contentItems[3].toInt()
                    FoodCard(name, brand, price, caloric)
                }
                ProductType.APPLIANCE ->{
                    val wattage = contentItems[3].toInt()
                    ApplianceCard(name, brand, price, wattage)
                }
                ProductType.SHOE ->{
                    val size = contentItems[3].toFloat()
                    ShoeCard(name, brand, price, size)
                }
            }
            cards.add(productCard)
        }
        return cards
    }

    fun showAllItems(){
        val content = fileProductCards.readText().trim()

        if (content.isEmpty()){
            return
        }

        val cardsAsString = content.split("\n")
        for (cardString in cardsAsString){
            // старая реализация
//            val contentItems = cardString.split("%")
//            val name = contentItems[0]
//            val brand = contentItems[1]
//            val price = contentItems[2].toInt()
//            val type = contentItems.last()
//            val productType = ProductType.valueOf(type)
//            val productCard = when (productType){
//                ProductType.FOOD -> {
//                    val caloric = contentItems[3].toInt()
//                    FoodCard(name, brand, price, caloric)
//                }
//                ProductType.APPLIANCE ->{
//                    val wattage = contentItems[3].toInt()
//                    ApplianceCard(name, brand, price, wattage)
//                }
//                ProductType.SHOE ->{
//                    val size = contentItems[3].toFloat()
//                    ShoeCard(name, brand, price, size)
//                }
//            }
//            productCard.printInfo()
            val cards = loadAllCards()
            for (card in cards){
                card.printInfo()
            }
        }
    }

    fun removeProductCard(){
        val cards: MutableList<ProductCard> = loadAllCards()
        print("Enter name of card for removing: ")
        val name = readln()
        for ((index, card) in cards.withIndex()){
            if (card.name == name){
                cards.removeAt(index)
                break
            }
        }
        fileProductCards.writeText("")
        for (card in cards){
            saveProductCardToFile(card)
        }

    }

    fun saveProductCardToFile(productCard: ProductCard){
        fileProductCards.appendText("${productCard.name}%${productCard.brand}%${productCard.price}%")
        when (productCard) {
            is FoodCard -> {
                val caloric = productCard.caloric
                fileProductCards.appendText("$caloric%")
            }

            is ApplianceCard -> {
                val wattage = productCard.wattage
                fileProductCards.appendText("$wattage%")
            }

            is ShoeCard -> {
                val size = productCard.size
                fileProductCards.appendText("$size%")
            }
        }
        fileProductCards.appendText("${productCard.productType}\n")
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
        saveProductCardToFile(card)
    }
}