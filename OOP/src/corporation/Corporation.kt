package corporation

fun main(){
    val assistant = WorkersRepository.findAssistant()
    assistant?.printInfo()
    val director = WorkersRepository.findDirector()
    if (assistant != null){
        director?.takeCoffee(assistant)
    }
}