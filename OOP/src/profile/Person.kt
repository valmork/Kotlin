package profile

class Person(
    private val name: String,
    private val age: Int,
    private val height: Int,
    private val weight: Int
) {


//    constructor(name: String, age: Int, height: Int, weight: Int) {
//        this.name = name
//        this.age = age
//        this.height = height
//        this.weight = weight
//    }


//    fun init(name: String, age: Int, height: Int, weight: Int){
//        this.name = name
//        this.age = age
//        this.height = height
//        this.weight = weight
//    }

    fun sayHello(name: String){
        println("Hello! My name is $name")
    }

    fun run(){
        repeat(10){
            print("Бегу...")
        }
        print("\n")
    }


    fun showInfo(){
        println("My name is $name\nI am $age years old\nMy height is $height\nMy weight is $weight")
    }
}