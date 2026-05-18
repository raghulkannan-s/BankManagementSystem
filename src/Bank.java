
import enums.ACCOUNT_TYPE;
import factory.AccountFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import model.Customer;
import repository.AccountRepository;
import repository.CustomerRepository;
import repository.TransactionHistoryRepository;
import service.AccountService;
import service.AdminService;
import service.CustomerService;
import service.TransactionHistoryService;
import service.TransactionService;
import util.FormIO;
import view.AccountView;
import view.AdminView;
import view.CustomerView;
import view.TransactionHistoryView;
import view.TransactionView;


public class Bank {
    public void start() throws Exception {
        

        System.out.println("Welcome to the Bank Management System!");

        Scanner sc = new Scanner(System.in);
        FormIO formIO = new FormIO(sc);

        CustomerRepository customerRepository = new CustomerRepository(new HashMap<>());
        CustomerService customerService = new CustomerService(customerRepository);
        CustomerView customerView = new CustomerView(sc, customerService, formIO);

        AccountFactory accountFactory = new AccountFactory();
        AccountRepository accountRepository = new AccountRepository(new HashMap<>());
        AccountService accountService = new AccountService(accountRepository, accountFactory);
        AccountView accountView = new AccountView(sc, accountService, customerService, formIO);

        
        TransactionHistoryRepository transactionHistoryRepository = new TransactionHistoryRepository(new ArrayList<>());
        TransactionHistoryService transactionHistoryService = new TransactionHistoryService(transactionHistoryRepository);
        TransactionHistoryView transactionHistoryView = new TransactionHistoryView(sc, transactionHistoryService);
        
        TransactionService transactionService = new TransactionService(accountService, transactionHistoryService);
        TransactionView transactionView = new TransactionView(sc, transactionService, accountService, formIO);

        AdminService adminService = new AdminService(customerService, accountService);
        AdminView adminView = new AdminView(sc, adminService, formIO, accountService);

        seedCustomers(customerService);
        seedAccounts(accountService, customerService);
        
        outer : while( true ){

            System.out.println("\n========================================");
            System.out.println("             MAIN MENU                  ");
            System.out.println("========================================");
            System.out.println("  1. Customer Services");
            System.out.println("  2. Account Services");
            System.out.println("  3. Transaction Services");
            System.out.println("  4. Transaction History");
            System.out.println("  5. Admin Controls");
            System.out.println("  6. Exit Application");
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
                case 1 :
                    customerView.start();
                    break;
                case 2 :
                    accountView.start();
                    break;
                case 3 :
                    transactionView.start();
                    break;
                case 4 : 
                    transactionHistoryView.start();
                    break;
                case 5 :
                    adminView.start();
                    break;
                case 6 :
                    break outer;
                default :
                    System.out.println("Wrong Choice!");
            }
        }
    }

    private static void seedCustomers(CustomerService customerService) {
        customerService.createAndSaveCustomer("Raghul", 21, "9876543210", "raghul@example.com", "12 North Street");
        customerService.createAndSaveCustomer("Bala", 31, "9876543211", "bala@example.com", "45 Lake Road");
        customerService.createAndSaveCustomer("Chitra", 24, "9876543212", "chitra@example.com", "78 Hill View");
        customerService.createAndSaveCustomer("Deepak", 36, "9876543213", "deepak@example.com", "9 Market Lane");
        customerService.createAndSaveCustomer("Esha", 27, "9876543214", "esha@example.com", "21 Park Avenue");
        customerService.createAndSaveCustomer("Farhan", 40, "9876543215", "farhan@example.com", "33 River Street");
        customerService.createAndSaveCustomer("Gokul", 29, "9876543216", "gokul@example.com", "16 Temple Road");
        customerService.createAndSaveCustomer("Heera", 22, "9876543217", "heera@example.com", "5 Sunrise Colony");
        customerService.createAndSaveCustomer("Ishaan", 34, "9876543218", "ishaan@example.com", "88 Coastal Drive");
        customerService.createAndSaveCustomer("Jaya", 26, "9876543219", "jaya@example.com", "14 Garden Street");
    }

    private static void seedAccounts(AccountService accountService, CustomerService customerService) {
        List<Customer> customers = customerService.getAllCustomers();
        accountService.createAndSaveAccount(customers.get(0).getCustomerId(), 5000.0, ACCOUNT_TYPE.SAVINGS);
        accountService.createAndSaveAccount(customers.get(1).getCustomerId(), 10000.0, ACCOUNT_TYPE.CURRENT);
        accountService.createAndSaveAccount(customers.get(2).getCustomerId(), 2000.0, ACCOUNT_TYPE.SAVINGS);
        accountService.createAndSaveAccount(customers.get(3).getCustomerId(), 15000.0, ACCOUNT_TYPE.CURRENT);
        accountService.createAndSaveAccount(customers.get(4).getCustomerId(), 7500.0, ACCOUNT_TYPE.SAVINGS);
    }
}


