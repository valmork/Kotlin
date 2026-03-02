package dogs

import command.Command
import command.Invoker
import java.util.concurrent.LinkedBlockingDeque
import kotlin.concurrent.thread

object DogsInvoker: Invoker<AdministratorCommands> {

    private val commands = LinkedBlockingDeque<Command>()

    init {
        thread {
            while (true){
                println("Waiting...")
                val command = commands.take()
                println("Executing command $command")
                command.execute()
                println("Executed command $command")
            }
        }
    }

    override fun addCommand(command: AdministratorCommands) {
        println("New command: $command")
        commands.add(command)
    }
}