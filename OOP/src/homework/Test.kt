package homework

fun main(){
    val encryptor = Encryptor()

    println(encryptor.process("sensitive data"))

    println(encryptor.transform("sensitive data"))

    val compressor = Compressor()

    println(compressor.process("large data"))

    println(compressor.transform("large data"))

    val logger = Logger()

    println(logger.process("log data"))
}