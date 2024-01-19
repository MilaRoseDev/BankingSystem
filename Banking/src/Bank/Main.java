package Bank;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank ("Bank of Mila");
    private static Customer customer = new Customer ("",0);



    public static void main(String[] args) {


        boolean quit = false;
        int choice = 0;
        printControls();
        while (!quit) {
            System.out.println(":     ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printControls();
                    break;
                case 1:
                    bank.addBranch("");
                    break;
                case 2:
                    bank.addCustomer("","",0);
                    break;
                case 3:
                    bank.listCustomers("",false);
                case 4:
                    bank.addCustomerTransaction("","",0);
                    break;
                case 5:
                    break;
                case 6:
                    quit = true;
                default:
                    System.out.println("Sorry incorrect input");
                    break;
            }
        }
    }

    public static void printControls () {
        System.out.println("\n Controls");
        System.out.println("\t 0 - Show controls.");
        System.out.println("\t 1 - Arrive Patient.");
        System.out.println("\t 2 - SignOut Patient.");
        System.out.println("\t 3 - Change Patient Name.");
        System.out.println("\t 4 - Search Patient.");
        System.out.println("\t 5 - Show Waiting List.");
        System.out.println("\t 6 - Close System.");
    }
}
