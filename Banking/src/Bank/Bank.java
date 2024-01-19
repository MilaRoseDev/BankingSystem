package Bank;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;

    }

    //****** data Validation with in the branch.
    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branchName != null) {
            return branch.newCustomer(customerName, initialAmount);

        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if (branchName != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    //******** check through the list of branches to find a match by branch name.
    private Branch findBranch(String branchName) {
        for (int i = 0; i < this.branches.size(); i++) {
            Branch checkedBranch = this.branches.get(i);
            if (checkedBranch.getName().equals(branchName)) {
                return checkedBranch;
            }
        }
        return null;
    }


    public boolean listCustomers(String branchName, boolean showTransaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer Details For Branch" + branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {                                          //List all customers from a specific branch.
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer:" + branchCustomer.getName() + "[" + (i + 1) + "]");
                if (showTransaction) {                                                                  //If the show transactions variable is set to true, show all transactions for specific customer
                    System.out.println("Transactions: ");                                               // Second loop to go through all the specfic customers transactions
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "]" + "Amount: " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }


}
