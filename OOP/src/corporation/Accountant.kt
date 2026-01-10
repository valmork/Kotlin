package corporation

import java.io.File

class Accountant(
    name: String,
    age: Int
): Worker(name, age) {

    val items = mutableListOf<ProductCard>()
    val file = File("product_cards.txt")

    override fun work() {
        var isExit: Boolean = false
        val operationCodeTypes = OperationCode.entries
        while (!isExit){
            for ((index, code) in operationCodeTypes.withIndex()) {
                print("$index - ${code.title}")
                if (index < operationCodeTypes.size - 1) {
                    print(", ")
                } else {
                    print(": ")
                }
            }
            print("Enter the operation code. 0 - exit, 1 - register new item: ")
            val choice = readln().toInt()
            val operationCodeChoice: OperationCode = operationCodeTypes[choice]
            when (operationCodeChoice){
                OperationCode.EXIT -> isExit = true
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                OperationCode.SHOW_ALL_ITEMS -> showAllItems()
                else -> println("Incorrect input")
            }
        }

    }

    fun showAllItems(){
        val content = file.readText().trim()
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
            productCard.printInfo()
        }

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
        file.appendText("$name%")
        print("Enter brand: ")
        val brand = readln()
        file.appendText("$brand%")
        print("Enter price: ")
        val price = readln().toInt()
        file.appendText("$price%")
        when (productChoice){
            ProductType.FOOD -> {
                print("Enter caloric: ")
                val caloric = readln().toInt()
                file.appendText("$caloric%")
            }
            ProductType.APPLIANCE -> {
                print("Enter wattage: ")
                val wattage = readln().toInt()
                file.appendText("$wattage%")
            }
            ProductType.SHOE -> {
                print("Enter size: ")
                val size = readln().toFloat()
                file.appendText("$size%")
            }
        }
        file.appendText("$productChoice\n")
    }
}