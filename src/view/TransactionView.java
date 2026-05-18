
package view;
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
        
        Account account = formIO.getExistingValidAccount(accountService);
        double amount = formIO.getValidAmount();

        double balance = transactionService.deposit(account, amount);

        if( balance == -2 ){
            System.out.println("Your Account is Blocked, Contact Branch!");
            return;
        }

        System.out.println("Your Balance : " + balance );
        
    }
    
    private void withdraw(){
        
        Account account = formIO.getExistingValidAccount(accountService);
        double amount = formIO.getValidAmount();

        double balance = transactionService.withdraw(account, amount);

        if(balance == -1){
            System.out.println("Your Balance is too low to withdraw!");
        }
        else{
            System.out.println("Your Balance : " + balance );
        }

    }
        
    private void fundTransfer(){
        
        System.out.println("Enter \"FROM ACCOUNT\" number ");
        Account fromAccount = formIO.getExistingValidAccount(accountService);
        
        System.out.println("Enter \"TO ACCOUNT\" number");
        Account toAccount = formIO.getExistingValidAccount(accountService);

        if( fromAccount.getAccountNumber() == toAccount.getAccountNumber() ){
            System.err.println("Sender and Receiver Can't be same!!");
            return;
        }
        
        System.out.println("Enter amount : ");
        double amount = formIO.getValidAmount();
        
        boolean hasAmount = accountService.checkIfHasAmount(fromAccount, amount);
        
        if( !hasAmount ){
            System.err.println("Sorry you don't have enough balance to transfer");
            return;
        }
        
        transactionService.transfer(fromAccount, toAccount, amount);
        System.out.println("Amount transferred Successfully!");

    }




}
