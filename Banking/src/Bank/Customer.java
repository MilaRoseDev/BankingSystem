package Bank;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;


    //initialize transaction
    public Customer(String name, double initialTransaction) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        addTransaction(initialTransaction);
    }

    public void addTransaction(Double amount){
        this.transactions.add(amount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}

