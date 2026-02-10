package products

fun main() {
    val products = ProductsRepository.products
    for (good in products){
        println(good)
    }
}