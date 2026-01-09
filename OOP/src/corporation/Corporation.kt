package corporation

fun main(){
    val consultant = Consultant("Nick", 20)
////    consultant.sayHello()
////    consultant.serveCustomers()
    val director = Director("Anton", 21)
//    director.forceToWork(consultant)
    val accountant: Accountant = Accountant("Anton", 21)
    val employees = listOf<Worker>(consultant, director, accountant)
    for (employee in employees){
        employee.work()
    }
}