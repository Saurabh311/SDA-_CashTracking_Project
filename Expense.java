package Shapes;

public class Expense extends Transactions {
    public Expense( int month, int amount){
        setMonth(month);
        setAmount(amount);
        setTittle("Expense");
    }
}
