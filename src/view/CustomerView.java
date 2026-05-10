package view;

import dto.Result;
import java.util.List;
import java.util.Scanner;
import model.Customer;
import service.CustomerService;
import util.FormIO;

public class CustomerView {

    Scanner sc;
    CustomerService customerService;

    public CustomerView(Scanner sc, CustomerService customerService) {
        this.sc = sc;
        this.customerService = customerService;
    }

    public void start(){

        System.out.println("================================");
        System.out.println("Select Your Customer Service :");
        System.out.println("1. Add New Customer ");
        System.out.println("2. View Customer Details ");
        System.out.println("3. Update Customer Details");
        System.out.println("4. Search Customer ");
        System.out.println("5. View All Customer ");
        System.out.println("6. Go Back to Main Menu ");
        System.out.println("================================");

        int choice = sc.nextInt();


        switch (choice) {
            case 1:
                addNewCustomer();
                break;
            case 2:
                getCustomerDetails();
                break;
            case 3:
                updateCustomerDetails();
                break;
            case 4:
                searchCustomerByName();
                break;
            case 5:
                viewAllCustomers();
                break;
            case 6:
                return;
            default:
                throw new AssertionError();
        }

    }

    public void searchCustomerByName(){

        System.out.println("Enter the Customer Name to search : ");
        String name = sc.next();
        List<Customer> customers = customerService.searchCustomerByName(name);

        if( customers == null ){
            System.err.println("No Data Found");
            return;
        }
        System.out.println("====================");
        System.out.println("Search Results : ");
        for( Customer customer : customers ){
            System.out.println(customer);
        }
        
    }

    public void searchCustomerById(){
        System.out.println("Enter the Customer ID to search : ");
        int customerId = sc.nextInt();
        Customer customer = customerService.getCustomerById(customerId);
        if( customer == null ){
            System.err.println("No Data Found");
            return;
        }
        System.out.println(customer);
    }

    public void viewAllCustomers(){

        List<Customer> customers = customerService.getAllCustomers();

        if(customers == null){
            System.out.println("There are no Customers in this Bank Currently!");
            return;
        }

        System.out.println("====================");
        System.out.println("List of Customers :");
        for( Customer customer : customers ){
            System.out.println(customer);
        }
        System.out.println("====================");


    }

    public void addNewCustomer(){

            System.out.println("Enter your Customer Details : ");
            
            FormIO formIO = new FormIO(sc);

            String name = formIO.getValidName();
            int age = formIO.getValidAge();
            String mobile = formIO.getValidMobile();
            String email = formIO.getValidEmail();
            String address = formIO.getValidAddress();

            Result res = customerService.addNewCustomer( new Customer(name, age, mobile, email, address) );

            System.out.println(res.getMessage());

    }

    public void getCustomerDetails(){

        System.out.println("Enter the Customer ID : ");
        int customerId = sc.nextInt();

        Customer customer = customerService.getCustomerById(customerId);

        if( customer == null ){
            System.err.println("No Data Found");
            return;
        }

        System.out.println(customer);
    }

    public void updateCustomerDetails(){

        System.out.print("Enter Customer ID to Update : ");
        int customerId = sc.nextInt();
        FormIO formIO = new FormIO(sc);

        Customer customer = customerService.getCustomerById(customerId);

        if( customer == null ){
            System.err.println("No Data Found");
            return;
        }

        String name = customer.getName();
        int age = customer.getAge();
        String mobile = customer.getMobile();
        String email = customer.getEmail();
        String address = customer.getAddress();

        outer : while( true ){

            System.out.println("current Customer Details : ");
            System.out.println(customer);
            System.out.println("====================");

            System.out.println("Enter which field to update : ");
            System.out.println("1. Name");
            System.out.println("2. Age");
            System.out.println("3. Mobile");
            System.out.println("4. Email");
            System.out.println("5. Address");
            System.out.println("6. Done");
            
            int fieldChoice = sc.nextInt();

            switch (fieldChoice) {
                case 1:
                    name = formIO.getValidName();
                    break;
                case 2:
                    age = formIO.getValidAge();
                    break;
                case 3:
                    mobile = formIO.getValidMobile();
                    break;
                case 4:
                    email = formIO.getValidEmail();
                    break;
                case 5:
                    address = formIO.getValidAddress();
                    break;
                case 6:
                    break outer;
                default:
                    System.err.println("Invalid Choice");
                    return;
            }
        }

        Result res = customerService.updateCustomerDetails(customerId, new Customer(name, age, mobile, email, address));

        System.out.println(res.getMessage());
    }

}
 