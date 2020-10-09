package Shapes;

public class Income extends Transactions {
    public Income (String tittle, int month, int amount){
        setMonth(month);
        setAmount(amount);
        setTittle(tittle);
        setType("Income");

    }

}
