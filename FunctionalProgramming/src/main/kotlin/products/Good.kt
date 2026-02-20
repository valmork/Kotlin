package products

import extensions.myAlso

fun main() {
    ProductsRepository.products.also {
        println("Filter")
    }.filter { it.productCategory == Category.CLOTHING }.also {
        println("Increase price")
    }.map { it.copy(productPrice = it.productPrice * 2.0) }.also {
        println("Convert to strings")
    }.map { "${it.id}-${it.productName}-${it.productPrice}" }.also {
        println("Print info")
    }.forEach { println(it) }
}



