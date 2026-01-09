package gui

class Rectangle {
    val height: Int
    val width: Int

    constructor(length: Int, width: Int) {
        this.height = length
        this.width = width
    }

    constructor(size: Int){
        this.height = size
        this.width = size
    }


    fun draw(width: Int, height: Int){
        repeat(height){
            repeat(width){
                print("* ")
            }
            print("\n")
        }
    }
}