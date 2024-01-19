package Bank;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>(); //initialise customer arraylist for a specific branch.
    }

    public String getName() {
        return name;
    }


    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    //******** If there is no record of the customer, this method will carry on and add a new customer and their amount.
    //******** If there is a match , the method will not add.
    public boolean newCustomer(String customerName, double initialAmount) {
        if (findCustomer(customerName) == null) {
            this.customers.add(new Customer(customerName, initialAmount));
            return true;
        }
        return false;

    }

    //******** call add transaction from the customer object class.
    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);
        if (existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;

    }

    //******** Check through the List of customers for the specific branch.
    private Customer findCustomer(String customerName) {
        for (int i = 0; i < this.customers.size(); i++) {
            Customer checkedCustomer = this.customers.get(i);
            if (checkedCustomer.getName().equals(customerName)) {
                return checkedCustomer;
            }
        }
        return null;
    }
}


