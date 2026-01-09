package corporation

fun main(){
    val consultant = Consultant("Nick", 20)
//    consultant.sayHello()
//    consultant.serveCustomers()
    val director = Director("Anton", 21)
    director.forceToWork(consultant)
}