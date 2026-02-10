package products

class ConditionPriceMoreThan500: Condition {

    override fun isSuitable(product: Product): Boolean {
        return product.productPrice > 500
    }
}