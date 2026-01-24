package profile

class Person(
    private val name: String,
    var lastName: String,
    private val height: Int,
    private val weight: Int
) {

    val fullName: String
        get() = name + " " + lastName

    var age: Int = 0
        set(value) {
            if (value > age){
                field = value
            }else{
                println("The new age must be bigger than the old one")
            }
        }
        get() {
            println("It is indecent to ask a person his age")
            return field
        }


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