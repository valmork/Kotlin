package gui

class Rectangle(
    var height: Int = 0,
    var width: Int = 0
) {

    val area: Int
        get() = width * height

    constructor(size: Int): this(size, size)


    fun draw(width: Int, height: Int){
        repeat(height){
            repeat(width){
                print("* ")
            }
            print("\n")
        }
    }
}