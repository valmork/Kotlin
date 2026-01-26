package corporation

import java.io.File

class ProductCardsRepository {

    val fileProductCards = File("product_cards.txt")
    val productCards = loadAllCards()

    fun registerNewItem(productCard: ProductCard){
        productCards.add(productCard)
    }

    fun saveChanges(){
        val content = StringBuilder()
        for (productCard in productCards){
            content.append("${productCard.name}%${productCard.brand}%${productCard.price}%")
            when (productCard) {
                is FoodCard -> {
                    val caloric = productCard.caloric
                    content.append("$caloric%")
                }

                is ApplianceCard -> {
                    val wattage = productCard.wattage
                    content.append("$wattage%")
                }

                is ShoeCard -> {
                    val size = productCard.size
                    content.append("$size%")
                }
            }
            content.append("${productCard.productType}\n")
        }
        fileProductCards.writeText(content.toString())
    }


    private fun loadAllCards(): MutableList<ProductCard> {
        val cards: MutableList<ProductCard> = mutableListOf<ProductCard>()

        if (!fileProductCards.exists()) fileProductCards.createNewFile()
        val content = fileProductCards.readText().trim()

        if (content.isEmpty()){
            return cards
        }

        val cardsAsString = content.split("\n")
        for (cardString in cardsAsString){
            val contentItems = cardString.split("%")
            val name = contentItems[0]
            val brand = contentItems[1]
            val price = contentItems[2].toInt()
            val type = contentItems.last()
            val productType = ProductType.valueOf(type)
            val productCard = when (productType){
                ProductType.FOOD -> {
                    val caloric = contentItems[3].toInt()
                    FoodCard(name, brand, price, caloric)
                }
                ProductType.APPLIANCE ->{
                    val wattage = contentItems[3].toInt()
                    ApplianceCard(name, brand, price, wattage)
                }
                ProductType.SHOE ->{
                    val size = contentItems[3].toFloat()
                    ShoeCard(name, brand, price, size)
                }
            }
            cards.add(productCard)
        }
        return cards
    }

    fun removeProductCard(name: String){
        for (card in productCards){
            if (card.name == name){
                productCards.remove(card)
                break
            }
        }
    }
}