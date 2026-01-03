fun main(){
    val source = readln().toInt()
    val hundreds: Int = source / 100
    val fifty: Int = (source % 100) / 50
    val twenty: Int = ((source % 100) % 50) / 20
    val ten: Int = (((source % 100) % 50) % 20) / 10
    val five: Int = ((((source % 100) % 50) % 20) % 10) / 5
    val two: Int = (((((source % 100) % 50) % 20) % 10) % 5) / 2
    val one: Int = (((((source % 100) % 50) % 20) % 10) % 5) % 2

    println("Вам доступно:\n100$ - ${hundreds}шт\n50$ - ${fifty}шт\n20$ - ${twenty}шт\n10$ - ${ten}шт\n5$ - ${five}шт\n2$ - ${two}шт\n1$ - ${one}шт")
}