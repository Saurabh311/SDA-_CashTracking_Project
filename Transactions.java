package Shapes;

public class Transactions {
    private String tittle;
    private int month;
    private int amount;


    public Transactions (String tittle, int month, int amount ){
        this.tittle = tittle;
        this.month = month;
        this.amount = amount;

    }
    // Default Constructor
    public Transactions (){
        this.tittle = "";
        this.month = 0;
        this.amount = 0;

    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getTittle() {
        return tittle;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }
}
