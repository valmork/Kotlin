package corporation

import java.io.File

class ProductCardsRepository {

    val fileProductCards = File("product_cards.txt")

    fun registerNewItem(productCard: ProductCard){
        saveProductCardToFile(productCard)
    }

    private fun saveProductCardToFile(productCard: ProductCard){
        fileProductCards.appendText("${productCard.name}%${productCard.brand}%${productCard.price}%")
        when (productCard) {
            is FoodCard -> {
                val caloric = productCard.caloric
                fileProductCards.appendText("$caloric%")
            }

            is ApplianceCard -> {
                val wattage = productCard.wattage
                fileProductCards.appendText("$wattage%")
            }

            is ShoeCard -> {
                val size = productCard.size
                fileProductCards.appendText("$size%")
            }
        }
        fileProductCards.appendText("${productCard.productType}\n")
    }

    fun loadAllCards(): MutableList<ProductCard> {
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
        val cards: MutableList<ProductCard> = loadAllCards()
        for ((index, card) in cards.withIndex()){
            if (card.name == name){
                cards.removeAt(index)
                break
            }
        }
        fileProductCards.writeText("")
        for (card in cards){
            saveProductCardToFile(card)
        }
    }
}