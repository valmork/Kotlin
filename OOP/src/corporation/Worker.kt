package corporation

abstract class Worker(
    val id: Int,
    val name: String,
    val age: Int = 0,
    val salary: Int = 15000,
    val position: Position
) {

    override fun equals(other: Any?): Boolean {
        if (other !is Worker) return false

        return (this.id == other.id &&
            this.name == other.name &&
            this.age == other.age &&
            this.salary == other.salary &&
            this.position == other.position)
    }

    abstract fun copy(salary: Int = this.salary, age: Int = this.age): Worker

    abstract fun work()

    fun printInfo() {
        println(this)
    }

    override fun toString(): String {
        return "Id: $id Name: $name Age: $age Position: $position Salary: $salary"
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + age
        result = 31 * result + salary
        result = 31 * result + name.hashCode()
        result = 31 * result + position.hashCode()
        return result
    }
}