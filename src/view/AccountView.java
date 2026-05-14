package view;

import enums.ACCOUNT_TYPE;
import factory.AccountFactory;
import java.util.Scanner;
import model.account.Account;
import service.AccountService;
import service.CustomerService;
import util.FormIO;




public class AccountView {

    private Scanner sc;
    private FormIO formIO = new FormIO(sc);
    private AccountService accountService;
    private CustomerService customerService;
    private AccountFactory accountFactory;

    public AccountView(Scanner sc, AccountService accountService, CustomerService customerService, AccountFactory accountFactory) {
        this.sc = sc;
        this.accountService = accountService;
        this.customerService = customerService;
        this.accountFactory = accountFactory;
    }

    public void start() {

        while ( true ) {

            System.out.println("Account Service");
            System.out.println("1. Create Account");
            System.out.println("2. View Account Details");
            System.out.println("3. Check Balance");
            System.out.println("4. Close Account");
            System.out.println("5. Back to Main Menu");

            int choice = sc.nextInt();

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

        int customerId = formIO.getExistingValidCustomerId(customerService);

        double initialDeposit;
        ACCOUNT_TYPE account_type;
        System.out.println("===========================");
        System.out.println("Enter Account Details");
        
        outer : while( true ){
            System.out.println("Enter Account Type : ");
            
            System.out.println("1. Savings ");
            System.out.println("2. Current ");
            System.out.println("===========================");
            
            int accChoice = sc.nextInt();

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

            initialDeposit = sc.nextInt();

            if( initialDeposit < 500 ) System.out.println("Please Enter a Amount >= 500 !");
            else break;

        }


        Account acc = accountFactory.createAccount(customerId, initialDeposit, account_type);
        accountService.addNewAccount(acc);
        System.out.println("Account created Successfully!");
        System.out.println("Account No : " + acc.getAccountNumber());

        
    }

    private void viewAccountDetails() {
        Account account = formIO.getExistingValidAccount(accountService);
        System.out.println(account);
    }

    private void checkBalance() {
        Account account = formIO.getExistingValidAccount(accountService);
        System.out.println("Your Balance : " + account.getBalance());

    }

    private void closeAccount() {
        Account account = formIO.getExistingValidAccount(accountService);
        if( account.getBalance() > 0 ) System.out.println("Please Withdraw All your money Before Deleting the account");
        else accountService.closeAccount(account.getAccountNumber());
    }




}
