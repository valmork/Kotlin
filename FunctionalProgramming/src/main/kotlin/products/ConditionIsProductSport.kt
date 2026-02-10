package products

class ConditionIsProductSport: Condition {

    override fun isSuitable(product: Product): Boolean {
        return product.productCategory == Category.SPORTS
    }
}