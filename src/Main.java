
import java.util.HashMap;
import java.util.Scanner;
import model.Customer;
import repository.CustomerRepository;
import service.CustomerService;
import view.CustomerView;


public class Main {
    public static void main(String[] args) throws Exception {
        

        System.out.println("Welcome to the Bank Management System!");

        Scanner sc = new Scanner(System.in);

        CustomerRepository customerRepository = new CustomerRepository(new HashMap<>());
        CustomerService customerService = new CustomerService(customerRepository);
        CustomerView customerView = new CustomerView(sc, customerService);

        seedCustomers(customerService);
        
        outer : while( true ){

            System.out.println("====================");
            System.out.println("Select Any Service :");
            System.out.println("1. Customer ");
            System.out.println("2. Account ");
            System.out.println("3. Transactional");
            System.out.println("4. Transfer ");
            System.out.println("5. Admin ");
            System.out.println("6. Exit ");
            System.out.println("====================");
            

            int choice = sc.nextInt();


            switch (choice) {
                case 1:
                    customerView.start();
                    break;
                case 6:
                    break outer;
                default:
                    throw new AssertionError();
            }

        }



        
    }

    private static void seedCustomers(CustomerService customerService) {
        customerService.addNewCustomer(new Customer("Arun", 28, "9876543210", "arun@example.com", "12 North Street"));
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
}



