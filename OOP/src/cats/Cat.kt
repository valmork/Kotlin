package cats

class Cat(name: String): CatsFamily() {

    fun playWithMouse(){
        println("Я играю с мышкой")
    }

    override fun eat() {
        println("Кушаю вискас")
    }
}