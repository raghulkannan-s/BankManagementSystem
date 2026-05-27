package view;

import enums.ACCOUNT_TYPE;
import exception.AccountInactiveException;
import exception.AccountNotFoundException;
import exception.CustomerNotFoundException;
import java.util.Scanner;
import model.Customer;
import model.account.Account;
import service.AccountService;
import service.CustomerService;
import util.FormIO;




public class AccountView {

    private Scanner sc;
    private AccountService accountService;
    private CustomerService customerService;
    private FormIO formIO;
    
    public AccountView(Scanner sc, AccountService accountService, CustomerService customerService, FormIO formIO) {
        this.sc = sc;
        this.accountService = accountService;
        this.customerService = customerService;
        this.formIO = formIO;
    }
  
    public void start() {

        while ( true ) {

            System.out.println("\n========================================");
            System.out.println("            ACCOUNT SERVICES            ");
            System.out.println("========================================");
            System.out.println("  1. Create New Account");
            System.out.println("  2. View Account Details");
            System.out.println("  3. Check Balance");
            System.out.println("  4. Close Account");
            System.out.println("  5. Go Back to Main Menu");
            System.out.println("========================================");
            System.out.print("Select an option: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    viewAccountDetails();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    closeAccount();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid Choice! Please try again.");
            }

        }
    }

    private void createAccount() {

        int customerId;
        while( true ){
            System.out.println("Enter Customer ID : ");
            System.out.println("Press 9 to Exit!");
            customerId = formIO.getValidCustomerId();

            if( customerId == 9 ) return;

            try {
                Customer customer = customerService.getCustomerById(customerId);
                System.out.println("Welcome "+ customer.getName());
                break;
            } catch( CustomerNotFoundException e ){
                System.out.println(e.getMessage());
            }
        }

        double initialDeposit;
        ACCOUNT_TYPE account_type;
        System.out.println("===========================");
        System.out.println("Enter Account Details");
        
        outer : while( true ){
            System.out.println("Enter Account Type : ");
            
            System.out.println("1. Savings ");
            System.out.println("2. Current ");
            System.out.println("===========================");
            
            System.out.print("Select an option: ");
            int accChoice = formIO.getIntInput();

            switch (accChoice) {
                case 1 -> {
                    account_type = ACCOUNT_TYPE.SAVINGS;
                    break outer;
                }
                case 2 -> {
                    account_type = ACCOUNT_TYPE.CURRENT;
                    break outer;
                }
                default -> System.out.println("Please enter a proper choice! example : Press 1 for Savings");
            }
        }

        while( true ){
            System.out.println("Enter initial deposit : ");

            initialDeposit = formIO.getDoubleInput();

            if( initialDeposit < 500 ) System.out.println("Please Enter a Amount >= 500 !");
            else break;

        }


        Account acc = accountService.createAndSaveAccount(customerId, initialDeposit, account_type);
        System.out.println("Account created Successfully!");
        System.out.println("Account No : " + acc.getAccountNumber());

        
    }

    private void viewAccountDetails() {
        Account account = getExistingValidAccount();
        if( account == null ) return;
        System.out.println(account);
    }

    private void checkBalance() {
        Account account = getExistingValidAccount();
        if( account == null ) return;
        System.out.println("Your Balance : " + account.getBalance());

    }

    private void closeAccount() {
        Account account = getExistingValidAccount();
        if( account == null ) return;
        if( account.getBalance() > 0 ) System.out.println("Please Withdraw All your money Before Deleting the account");
        else accountService.closeAccount(account.getAccountNumber());
    }

    private Account getExistingValidAccount(){
        while( true ){
            System.out.println("Enter Account Number : ");
            System.out.println("Press 9 to Exit!");
            long accountNumber = formIO.getValidAccountNumber();

            if( accountNumber == 9 ) return null;

            try {
                return accountService.getActiveAccountByNumber(accountNumber);
            } catch( AccountNotFoundException | AccountInactiveException e ){
                System.out.println(e.getMessage());
            }
        }
    }




}
