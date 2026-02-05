package profile

data class Person(
    val name: String,
    val lastName: String,
    val height: Int,
    val weight: Int
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