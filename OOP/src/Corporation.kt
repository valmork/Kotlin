fun main(){
    print("Enter name: ")
    val name = readln()
    print("Enter brand: ")
    val brand = readln()
    print("Enter size: ")
    val size = readln().toFloat()
    print("Enter price: ")
    val price = readln().toInt()

    val productCard = ProductCard()
    productCard.name = name
    productCard.brand = brand
    productCard.size = size
    productCard.price = price

}