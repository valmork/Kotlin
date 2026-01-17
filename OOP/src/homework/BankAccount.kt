package homework

open class BankAccount(
    private var balance: Int = 0
) {

    fun deposit(amount: Int){
        if (amount < 0){
            return
        } else{
            balance += amount
        }
    }

    protected fun withdraw(amount: Int){
        if (amount < 0 || amount > balance){
            return
        }
        else{
            balance -= amount
        }
    }

    fun getBalance(): Int{
        return balance
    }
}