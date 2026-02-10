package products

import kotlinx.serialization.json.Json
import java.io.File

object ProductsRepository {

    private val file = File("products.json")

    private val _products = loadAllProducts()
    val products
        get() = _products.toList()

    private fun loadAllProducts(): List<Product>{
        val content = file.readText().trim()
        return Json.decodeFromString(content)
    }
}