package profile

class ConditionIsMale: Condition {

    override fun isSuitable(person: Person): Boolean {
        return person.gender == Gender.MALE
    }
}