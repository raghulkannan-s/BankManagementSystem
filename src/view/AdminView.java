
package view;

import java.util.List;
import java.util.Scanner;
import model.Customer;
import model.account.Account;
import service.AccountService;
import service.AdminService;
import util.FormIO;

public class AdminView {

    private Scanner sc;
    private AdminService adminService;
    private FormIO formIO;
    private AccountService accountService;

    public AdminView(Scanner sc, AdminService adminService, FormIO formIO, AccountService accountService){
        this.sc = sc;
        this.adminService = adminService;
        this.formIO = formIO;
        this.accountService = accountService;
    }

    public void start(){
        while( true ){

            System.out.println("Admin Service : ");
            System.out.println("1. View All Customers");
            System.out.println("2. View All Accounts");
            System.out.println("3. Block Account");
            System.out.println("4. Unblock Account");
            System.out.println("5. View Total Balance");
            System.out.println("6. Go Back to main menu");

            System.out.print("Select an option: ");
            int choice = formIO.getIntInput();

            switch (choice) {
                case 1:
                    viewAllCustomers();
                    break;
                case 2:
                    viewAllAccounts();
                    break;
                case 3:
                    blockAccount();
                    break;
                case 4:
                    unblockAccount();
                    break;
                case 5:
                    double totalBalance = adminService.viewTotalBalance();
                    System.out.println("Total Bank Balance : " + totalBalance);
                case 6:
                    return;
                default:
                    System.out.println("Wrong Choice!");
            }
        }
    }

    public void viewAllCustomers(){

        List<Customer> customers = adminService.getAllCustomer();

        if( customers.size() == 0 ){
            System.out.println("Sorry No Customers are yet there!");
            return;
        }
        
        for( Customer customer : customers ){
            System.out.println(customer.toString());
        }
    }
    
    public void viewAllAccounts(){

        List<Account> accounts = adminService.getAllAccounts();
        
        if( accounts.size() == 0 ){
            System.out.println("Sorry No Accounts are yet there!");
            return;
        }
        
        for( Account account : accounts ){
            System.out.println(account.toString());
        }

    }

    public void blockAccount(){
        Account account = formIO.getExistingValidAccount(accountService);
        adminService.blockAccount(account);
    }
    
    public void unblockAccount(){
        Account account = formIO.getExistingValidAccount(accountService);
        adminService.unblockAccount(account);
    }

    


}
