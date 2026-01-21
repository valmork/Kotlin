package corporation

class ShoeCard(
    name: String,
    brand: String,
    price: Int,
    val size: Float
): ProductCard(name, brand, price, ProductType.APPLIANCE) {
    override fun printInfo() {
        print("Name: $name Brand: $brand Price: $price Product type: ${productType.title} Size: $size\n")
    }
}