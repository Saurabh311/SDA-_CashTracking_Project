package Shapes;

import Shapes.Transactions;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Funct {
    Scanner scan = new Scanner(System.in);
    int balance;

    // Create ArrayList of all transaction

    ArrayList<Transactions> transactionList = new ArrayList<Transactions>();
    FileOutputStream fs = new FileOutputStream("testSer.ser");
    ObjectOutputStream os = new ObjectOutputStream(fs);

    FileInputStream fis = new FileInputStream("testSer.ser");
    ObjectInputStream ois = new ObjectInputStream(fis);

    public Funct() throws IOException {
    }

    void startApp() throws InterruptedException, IOException {
        boolean condit = true;
        System.out.println("Welcome to TrackMoney");
        while (condit) { // display the menu, take user input and revert
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
                    System.out.println("You choose to quite. Thankyou and welcome again\n");
                    condit = false;
                    break;

                default:
                    System.out.println("No valid choice, try again\n");
            }
        }
    }

    public void showTrans() {  // Method to see cash transaction
        System.out.println("Please select one option \n If you want to see all press 1 \n if you want to see only expenses press 2 \n If you want see only income press 3");
        int opt1 = scan.nextInt();
        switch (opt1) {
            case 1:
                for (int i = 0; i < transactionList.size(); i++) {
                    int snum = i + 1;
                    String head = transactionList.get(i).getTittle();
                    int month = transactionList.get(i).getMonth();
                    int amount = transactionList.get(i).getAmount();
                    String type = transactionList.get(i).getType();
                    System.out.println("S.No: " + snum + " Month: " + month + " Amount: " + amount + "  " + head +" "+ type);
                    }
                break;

            case 2:
                for (int i = 0; i < transactionList.size(); i++) {
                    String type = transactionList.get(i).getType();
                    int month = transactionList.get(i).getMonth();
                    int amount = transactionList.get(i).getAmount();
                    String head = transactionList.get(i).getTittle();
                    if (type == "Expense") {
                        int snum = i + 1;
                        System.out.println("S.No: " + snum + " Month: " + month + " Amount: " + amount + "  " + head+" "+ type);
                    }
                }
                break;
            case 3:
                for (int i = 0; i < transactionList.size(); i++) {
                    String type = transactionList.get(i).getType();
                    int month = transactionList.get(i).getMonth();
                    int amount = transactionList.get(i).getAmount();
                    String head = transactionList.get(i).getTittle();
                    if (type == "Income") {
                        int snum = i + 1;
                        System.out.println("S.No: " + snum + " Month: " + month + " Amount: " + amount + "  " + head);
                    }
                }
                break;
            default:
                System.out.println("No valid choice, try again\n");
        }
    }
    // Method to add cash transaction
    public void addItem() throws IOException { //this function add the new transactions
        while(true){
            System.out.println("Press 1 if want to add expenses or press 2 if you want to add income.");
            int opt2 = scan.nextInt();
            if (opt2 == 1) {
                System.out.println("Write description of transaction ");
                String tittle = scan.next();
                System.out.println(tittle);
                System.out.println(" Enter the month (1-12) ");
                int month = scan.nextInt();
                System.out.println(" Enter the amount ");
                int amount = scan.nextInt();
                transactionList.add(new Expense(tittle, month, amount));
                os.writeObject(transactionList);
             break;
            } else if (opt2 ==2) {
                System.out.println("Write description of transaction ");
                String tittle = scan.next();
                System.out.println(" Enter the month (1-12) ");
                int month = scan.nextInt();
                System.out.println(" Enter the amount ");
                int amount = scan.nextInt();
                transactionList.add(new Income(tittle, month, amount));
                os.writeObject(transactionList);
            break;
            } else {
                System.out.println("No valid choice, try again\n");
                }
        }}
    public void removeItem() throws IOException {     // this function remove and edit the transaction
        showAll();
        System.out.println("Please enterl S.no of item to be edit or remove");
        int choose = scan.nextInt();
        System.out.println("For delete this item press 1 or press 2 for edit ");
        int isRemove = scan.nextInt();
        if (isRemove == 1) {
            transactionList.remove(choose - 1);
            os.writeObject(transactionList);
        }else if(isRemove ==2) {
            System.out.println("Write new tittle ");
            String tittle = scan.next();
            System.out.println("Change the month (select month between 1-12) ");
            int month = scan.nextInt();
            System.out.println("New the amount ");
            int amount = scan.nextInt();
            System.out.println("write Income or Expense ");
            String type = scan.next();
            transactionList.set(choose - 1, new Transactions(tittle, month, amount, type));
            os.writeObject(transactionList);
        } else {
            System.out.println("No valid choice, try again\n");
        }
    }
    public void showAll(){     // This function show all the transaction and details
        for (int i = 0; i < transactionList.size(); i++) {
            int snum = i + 1;
            String head = transactionList.get(i).getTittle();
            int month = transactionList.get(i).getMonth();
            int amount = transactionList.get(i).getAmount();
            String type = transactionList.get(i).getType();
            System.out.println("S.No: " + snum + " Month: " + month + " Amount: " + amount + "  " + head+" "+ type);
        }
    }
    public int getBalance() {    // This function calculate the latest balance
        int balance =0;
        for (int x = 0; x < transactionList.size(); x++) {
            String type = transactionList.get(x).getType();
            int amount = transactionList.get(x).getAmount();
            if (type=="Income") {
                balance = balance + amount;
            } else {
                balance = balance - amount;
            }
        }
        return balance;
    }
    public void getAll(){
        System.out.println(" Enter the month (1-12) ");
        int month = scan.nextInt();
        System.out.println(" Enter the amount ");
        int amount = scan.nextInt();
        System.out.println("Write description of transaction ");
        String tittle = scan.next();
    }

}
