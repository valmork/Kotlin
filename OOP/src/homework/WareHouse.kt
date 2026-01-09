package homework

class WareHouse {
    fun getPack(deliveryObject: DeliveryObject): Pack {
        val pack = Pack(
            length = deliveryObject.length + 1,
            width = deliveryObject.width + 1,
            height = deliveryObject.height + 1,
            weight = 0.3,
        )
        return pack
    }

    fun packCargo(deliveryObject: DeliveryObject): Cargo {
        val cargo = Cargo(
            length = getPack(deliveryObject).length,
            width = getPack(deliveryObject).width,
            height = getPack(deliveryObject).height,
            typePackaging = getPack(deliveryObject).type,
            netWeight = deliveryObject.weight,
            grossWeight = deliveryObject.weight + getPack(deliveryObject).weight
        )
        return cargo
    }
}

//fun task(){
//    val source = readln()
//    val sourceElements = source.split(" ")
//    val length= sourceElements[0].toInt()
//    val width = sourceElements[1].toInt()
//    val height = sourceElements[2].toInt()
//    val weight = sourceElements[3].toDouble()
//    val deliveryObject = DeliveryObject(length, width, height, weight)
//    val wareHouse = WareHouse()
//    wareHouse.packCargo(deliveryObject).printInfo()
//}