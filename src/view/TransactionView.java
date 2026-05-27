
package view;
import exception.AccountInactiveException;
import exception.AccountNotFoundException;
import exception.InsufficientBalanceException;
import java.util.Scanner;
import model.account.Account;
import service.AccountService;
import service.TransactionService;
import util.FormIO;

public class TransactionView {

    private Scanner sc;
    private final TransactionService transactionService;
    private final AccountService accountService;
    private final FormIO formIO;
    
    public TransactionView(Scanner sc, TransactionService transactionService, AccountService accountService, FormIO formIO) {
        this.sc = sc;
        this.transactionService = transactionService;
        this.accountService = accountService;
        this.formIO = formIO;
    }
    
    public void start() {

        
        while( true ){

            System.out.println("Transaction Services");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Fund Transfer");
            System.out.println("4. Back to Main Menu");
            
            System.out.print("Select an option: ");
            int choice = formIO.getIntInput();

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    fundTransfer();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid Choice! Please try again.");
            }
        }

    }

    private void deposit(){
        
        Account account = getExistingValidAccount();
        if( account == null ) return;
        double amount = formIO.getValidAmount();

        double balance = transactionService.deposit(account, amount);
        System.out.println("Your Balance : " + balance );
        
    }
    
    private void withdraw(){
        
        Account account = getExistingValidAccount();
        if( account == null ) return;
        double amount = formIO.getValidAmount();

        try {
            double balance = transactionService.withdraw(account, amount);
            System.out.println("Your Balance : " + balance );
        } catch( InsufficientBalanceException e ){
            System.out.println(e.getMessage());
        }

    }
        
    private void fundTransfer(){
        
        System.out.println("Enter \"FROM ACCOUNT\" number ");
        Account fromAccount = getExistingValidAccount();
        if( fromAccount == null ) return;
        
        System.out.println("Enter \"TO ACCOUNT\" number");
        Account toAccount = getExistingValidAccount();
        if( toAccount == null ) return;

        if( fromAccount.getAccountNumber() == toAccount.getAccountNumber() ){
            System.err.println("Sender and Receiver Can't be same!!");
            return;
        }
        
        System.out.println("Enter amount : ");
        double amount = formIO.getValidAmount();
        
        try {
            transactionService.transfer(fromAccount, toAccount, amount);
            System.out.println("Amount transferred Successfully!");
        } catch( InsufficientBalanceException e ){
            System.err.println("Sorry you don't have enough balance to transfer");
        }

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
