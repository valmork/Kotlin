package products


interface Condition {

    fun isSuitable(product: Product): Boolean
}