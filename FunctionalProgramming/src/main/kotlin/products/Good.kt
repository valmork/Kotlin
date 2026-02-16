package products

fun main() {
    val products = ProductsRepository.products
        .filter { it.productCategory == Category.CLOTHING }
        .transform { it.copy(productPrice = it.productPrice * 2.0) }
        .transform { "${it.id}-${it.productName}-${it.productPrice}" }
    for (product in products){
        println(
            product
        )
    }
}

fun <R> List<Product>.transform(operation: (Product) -> R): List<R>{
    val result = mutableListOf<R>()
    for (product in this){
        result.add(operation(product))
    }
    return result
}

fun List<Product>.filter(isSuitable: (Product) -> Boolean): List<Product>{
    val newProducts = mutableListOf<Product>()
    for (product in this){
        if (isSuitable(product)){
           newProducts.add(product)
        }
    }
    return newProducts
}

//fun <T, R> transform(parameters: List<T>, operation: (T) -> R): List<R> {
//    // Реализация функции
//    val result = mutableListOf<R>()
//    for (parameter in parameters){
//        result.add(operation(parameter))
//    }
//    return result
//}