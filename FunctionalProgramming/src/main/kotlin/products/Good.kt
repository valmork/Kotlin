package products

fun main() {
    val products = ProductsRepository.products
        .filter { it.productCategory == Category.CLOTHING }
        .map { it.copy(productPrice = it.productPrice * 2.0) }
        .map { "${it.id}-${it.productName}-${it.productPrice}" }
    for (product in products){
        println(
            product
        )
    }
}



