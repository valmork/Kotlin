package products

fun main() {
    val products = ProductsRepository.products
    var filtered = filter(products) { it.productPrice > 500}
    filtered = filter(filtered) { it.productCategory == Category.SPORTS}
    filtered = filter(filtered) { it.productRating > 4.5}
    for (profile in filtered){
        println(profile)
    }
}

fun filter(products: List<Product>, isSuitable: (Product) -> Boolean): List<Product>{
    val newProducts = mutableListOf<Product>()
    for (product in products){
        if (isSuitable(product)){
           newProducts.add(product)
        }
    }
    return newProducts
}