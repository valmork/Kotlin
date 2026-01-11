package homework

data class Order(
    val id: Int,
    val status: String,
    val type: String
)

fun removeCompletedOrders(orders: List<Order>, typeToRemove: String): List<Order> {
    // напишите здесь ваше решение
    val myOrdersList = orders.toMutableList()
    for (order in orders){
        if (order.type == typeToRemove && order.status == "completed"){
            myOrdersList.remove(order)
        }
    }
    return myOrdersList
}