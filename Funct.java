package Shapes;

import java.util.ArrayList;
import java.util.Scanner;

public class Funct {
    Scanner scan = new Scanner(System.in);
    int balance;

    // Create ArrayList of all transaction
    ArrayList<Transactions> transactionList = new ArrayList<Transactions>();

    void startApp() throws InterruptedException {
        boolean condit = true;

        System.out.println("Welcome to TrackMoney");
        while (condit) {
            balance = getBalance();
            System.out.println("You have currently " + balance + " kr on your account \nPick an option : \n(1) Show Items (All/Expenses(s)/Income(s) \n(2) Add New Expense/Income \n(3) Edit Item (Edit/Remove)\n(4) Save and Quit");
            int option = scan.nextInt();
            switch (option) {
                case 1:
                    showTrans();
                    break;

                case 2:
                    addItem();
                    break;

                case 3:
                    removeItem();
                    break;

                case 4:
                    System.out.println("You choose to quite. Thankyou and welcome again");
                    condit = false;
                    break;

                default:
                    System.out.println("No valid choice, try again");

            }
        }
    }
    // Method to see cash transaction
    public void showTrans() {
        System.out.println("Please select one option \n If you want to see all press 1 \n if you want to see only expenses press 2 \n If you want see only income press 3");
        int opt1 = scan.nextInt();
        switch (opt1) {
            case 1:
                for (int i = 0; i < transactionList.size(); i++) {
                    int snum = i + 1;
                    String head = transactionList.get(i).getTittle();
                    int month = transactionList.get(i).getMonth();
                    int amount = transactionList.get(i).getAmount();
                    System.out.println("S.No: " + snum + " Month: " + month + " Amount: " + amount + "  " + head);
                    }
                break;

            case 2:
                for (int i = 0; i < transactionList.size(); i++) {
                    int snum = i + 1;
                    String head = transactionList.get(i).getTittle();
                    int month = transactionList.get(i).getMonth();
                    int amount = transactionList.get(i).getAmount();
                    if (head == "Expense") {
                        System.out.println("S.No: " + snum + " Month: " + month + " Amount: " + amount + "  " + head);
                    }
                }
                break;

            case 3:
                for (int i = 0; i < transactionList.size(); i++) {
                    int snum = i + 1;
                    String head = transactionList.get(i).getTittle();
                    int month = transactionList.get(i).getMonth();
                    int amount = transactionList.get(i).getAmount();
                    if (head == "Income") {
                        System.out.println("S.No: " + snum + " Month: " + month + " Amount: " + amount + "  " + head);
                    }
                }
                break;
        }
    }
    // Method to add cash transaction
    public void addItem() {
        System.out.println("Press 1 if want to add expenses or press 2 if you want to add income.");
        int opt2 = scan.nextInt();
        switch (opt2) {
            case 1:
                System.out.println(" Enter the month (1-12) ");
                int month = scan.nextInt(12);
                System.out.println(" Enter the amount ");
                int amount = scan.nextInt();
                transactionList.add(new Expense(month, amount));
                break;
            case 2:
                System.out.println(" Enter the month (1-12) ");
                month = scan.nextInt(12);
                System.out.println(" Enter the amount ");
                amount = scan.nextInt();
                transactionList.add(new Income(month, amount));
                break;
        }

    }

    public void removeItem() {
        showAll();
        System.out.println("Please enterl S.no of item to be edit or remove");
        int choose = scan.nextInt();
        System.out.println("For delete this item press 1 or press 2 for edit ");
        int isRemove = scan.nextInt();
        switch (isRemove) {
            case 1:
                transactionList.remove(choose - 1);
                break;
            case 2:
                System.out.println("Write new tittle ");
                String tittle = scan.next();
                System.out.println("Change the month (1-12) ");
                int month = scan.nextInt();
                System.out.println("New the amount ");
                int amount = scan.nextInt();
                transactionList.set(choose - 1, new Transactions(tittle, month, amount));
                break;
        }
    }

    public void showAll() {
        for (int i = 0; i < transactionList.size(); i++) {
            int snum = i + 1;
            String head = transactionList.get(i).getTittle();
            int month = transactionList.get(i).getMonth();
            int amount = transactionList.get(i).getAmount();
            System.out.println("S.No: " + snum + " Month: " + month + " Amount: " + amount + "  " + head);
        }
    }
    public int getBalance() {
        int balance = 0;  
        for (int x = 0; x < transactionList.size(); x++) {
            String head = transactionList.get(x).getTittle();
            int amount = transactionList.get(x).getAmount();

            if (head == "Income") {
                balance = balance + amount;
            } else {
                balance = balance - amount;
            }
        }
        return balance;
    }
}
