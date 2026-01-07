class Person {
    var name: String = ""
    var age: Int = 0
    var height: Int = 0
    var weight: Int = 0

    fun init(name: String, age: Int, height: Int, weight: Int){
        this.name = name
        this.age = age
        this.height = height
        this.weight = weight
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