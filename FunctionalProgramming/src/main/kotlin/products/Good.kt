package products

fun main() {
    val products = ProductsRepository.products
    var filtered = filter(products, object : Condition {
        override fun isSuitable(product: Product): Boolean {
            return product.productPrice > 500
        }
    })
    filtered = filter(filtered, object : Condition {
        override fun isSuitable(product: Product): Boolean {
            return product.productCategory == Category.SPORTS
        }
    })
    filtered = filter(filtered, object : Condition {
        override fun isSuitable(product: Product): Boolean {
            return product.productRating > 4.5
        }
    })
    for (profile in filtered){
        println(profile)
    }
}

fun filter(products: List<Product>, condition: products.Condition): List<Product>{
    val newProducts = mutableListOf<Product>()
    for (product in products){
        if (condition.isSuitable(product)){
           newProducts.add(product)
        }
    }
    return newProducts
}