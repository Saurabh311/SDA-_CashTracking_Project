package Shapes;

public class Expense extends Transactions {
    public Expense( String tittle, int month, int amount){
        setMonth(month);
        setAmount(amount);
        setTittle(tittle);
        setType("Expenses");
    }
}
