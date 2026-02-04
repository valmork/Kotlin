package profile

class Person(
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

    fun copy(name: String = this.name,
             lastName: String = this.lastName,
             height: Int = this.height,
             weight: Int = this.weight): Person{
        return Person(name, lastName, height, weight)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (height != other.height) return false
        if (weight != other.weight) return false
        if (name != other.name) return false
        if (lastName != other.lastName) return false

        return true
    }

    override fun hashCode(): Int {
        var result = height
        result = 31 * result + weight
        result = 31 * result + name.hashCode()
        result = 31 * result + lastName.hashCode()
        return result
    }

    override fun toString(): String {
        return "Person(name='$name', lastName='$lastName', height=$height, weight=$weight, fullName='$fullName', age=$age)"
    }


}