package products

class ConditionProductHighRating: Condition {

    override fun isSuitable(product: Product): Boolean {
        return product.productRating > 4.5
    }
}