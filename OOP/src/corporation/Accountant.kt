package corporation

class Accountant(
    name: String,
    age: Int
): Worker(name, age) {
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
            val operationCode = operationCodeTypes[choice]
            val operationCodeChoice: OperationCode = operationCodeTypes[choice]
            when (operationCodeChoice){
                OperationCode.EXIT -> isExit = true
                OperationCode.REGISTER_NEW_ITEM -> registerNewItem()
                else -> println("Incorrect input")
            }
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
        print("Enter brand: ")
        val brand = readln()
        print("Enter price: ")
        val price = readln().toInt()
        when (productChoice){
            ProductType.FOOD -> {
                print("Enter caloric: ")
                val caloric = readln().toInt()
                val food: FoodCard = FoodCard(name, brand, price, caloric)
                food.printInfo()
            }
            ProductType.APPLIANCE -> {
                print("Enter wattage: ")
                val wattage = readln().toInt()
                val appliance: ApplianceCard = ApplianceCard(name, brand, price, wattage)
                appliance.printInfo()
            }
            ProductType.SHOE -> {
                print("Enter size: ")
                val size = readln().toFloat()
                val shoe: ShoeCard = ShoeCard(name, brand, price, size)
                shoe.printInfo()
            }
            else -> println("Incorrect input")
        }
    }
}