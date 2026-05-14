
import enums.ACCOUNT_TYPE;
import factory.AccountFactory;
import java.util.HashMap;
import java.util.Scanner;
import model.Customer;
import repository.AccountRepository;
import repository.CustomerRepository;
import service.AccountService;
import service.CustomerService;
import view.AccountView;
import view.CustomerView;

public class Main {
    public static void main(String[] args) throws Exception {
        

        System.out.println("Welcome to the Bank Management System!");

        Scanner sc = new Scanner(System.in);

        CustomerRepository customerRepository = new CustomerRepository(new HashMap<>());
        CustomerService customerService = new CustomerService(customerRepository);
        CustomerView customerView = new CustomerView(sc, customerService);

        AccountFactory accountFactory = new AccountFactory();
        AccountRepository accountRepository = new AccountRepository(new HashMap<>());
        AccountService accountService = new AccountService(accountRepository);
        AccountView accountView = new AccountView(sc, accountService, customerService, accountFactory);


        seedCustomers(customerService);
        seedAccounts(accountService, accountFactory);
        
        outer : while( true ){

            System.out.println("====================");
            System.out.println("Select Any Service :");
            System.out.println("1. Customer ");
            System.out.println("2. Account ");
            System.out.println("3. Transactional");
            System.out.println("4. Fund Transfer ");
            System.out.println("5. Admin ");
            System.out.println("6. Exit ");
            System.out.println("====================");
            
            int choice = sc.nextInt();
 
            switch (choice) {
                case 1:
                    customerView.start();
                    break;
                case 2:
                    accountView.start();
                    break;
                case 6:
                    break outer;
                default:
                    throw new AssertionError();
            }

        }



        
    }

    private static void seedCustomers(CustomerService customerService) {
        customerService.addNewCustomer(new Customer("raghul", 21, "9876543210", "arun@example.com", "12 North Street"));
        customerService.addNewCustomer(new Customer("Bala", 31, "9876543211", "bala@example.com", "45 Lake Road"));
        customerService.addNewCustomer(new Customer("Chitra", 24, "9876543212", "chitra@example.com", "78 Hill View"));
        customerService.addNewCustomer(new Customer("Deepak", 36, "9876543213", "deepak@example.com", "9 Market Lane"));
        customerService.addNewCustomer(new Customer("Esha", 27, "9876543214", "esha@example.com", "21 Park Avenue"));
        customerService.addNewCustomer(new Customer("Farhan", 40, "9876543215", "farhan@example.com", "33 River Street"));
        customerService.addNewCustomer(new Customer("Gokul", 29, "9876543216", "gokul@example.com", "16 Temple Road"));
        customerService.addNewCustomer(new Customer("Heera", 22, "9876543217", "heera@example.com", "5 Sunrise Colony"));
        customerService.addNewCustomer(new Customer("Ishaan", 34, "9876543218", "ishaan@example.com", "88 Coastal Drive"));
        customerService.addNewCustomer(new Customer("Jaya", 26, "9876543219", "jaya@example.com", "14 Garden Street"));
    }

    private static void seedAccounts(AccountService accountService, AccountFactory accountFactory) {
        accountService.addNewAccount(accountFactory.createAccount(1, 5000.0, ACCOUNT_TYPE.SAVINGS));
        accountService.addNewAccount(accountFactory.createAccount(2, 10000.0, ACCOUNT_TYPE.CURRENT));
        accountService.addNewAccount(accountFactory.createAccount(3, 2000.0, ACCOUNT_TYPE.SAVINGS));
        accountService.addNewAccount(accountFactory.createAccount(4, 15000.0, ACCOUNT_TYPE.CURRENT));
        accountService.addNewAccount(accountFactory.createAccount(5, 7500.0, ACCOUNT_TYPE.SAVINGS));
    }
}


