package dogs

fun main() {
    DogsRepository.getInstance("dogs").dogs.forEach ( ::println )
}