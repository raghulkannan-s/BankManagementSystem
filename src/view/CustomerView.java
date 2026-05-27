package view;

import dto.Result;
import exception.CustomerNotFoundException;
import java.util.List;
import java.util.Scanner;
import model.Customer;
import service.CustomerService;
import util.FormIO;

public class CustomerView {

    private Scanner sc;
    private CustomerService customerService;
    private FormIO formIO;

    public CustomerView(Scanner sc, CustomerService customerService, FormIO formIO) {
        this.sc = sc;
        this.customerService = customerService;
        this.formIO = formIO;
    }

    public void start(){

        while (true) {
            System.out.println("\n========================================");
            System.out.println("          CUSTOMER SERVICES             ");
            System.out.println("========================================");
            System.out.println("  1. Add New Customer");
            System.out.println("  2. View Customer Details");
            System.out.println("  3. Update Customer Details");
            System.out.println("  4. Search Customer By Name");
            System.out.println("  5. View All Customers");
            System.out.println("  6. Go Back to Main Menu");
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
                    System.out.println("Wrong Choice!");
            }
        }
    }

    public void searchCustomerByName(){

        System.out.println("Enter the Customer Name to search : ");
        String name = formIO.getStringInput();
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
        int customerId = formIO.getIntInput();
        try {
            Customer customer = customerService.getCustomerById(customerId);
            System.out.println(customer);
        } catch( CustomerNotFoundException e ){
            System.err.println("No Data Found");
        }
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

            String name = formIO.getValidName();
            int age = formIO.getValidAge();
            String mobile = formIO.getValidMobile();
            String email = formIO.getValidEmail();
            String address = formIO.getValidAddress();

            Result res = customerService.createAndSaveCustomer(name, age, mobile, email, address);

            System.out.println(res.getMessage());

    }

    public void getCustomerDetails(){

        System.out.println("Enter the Customer ID : ");
        int customerId = formIO.getValidCustomerId();

        try {
            Customer customer = customerService.getCustomerById(customerId);
            System.out.println(customer);
        } catch( CustomerNotFoundException e ){
            System.err.println("No Data Found");
        }
    }

    public void updateCustomerDetails(){

        System.out.print("Enter Customer ID to Update : ");
        int customerId = formIO.getValidCustomerId(); 

        Customer customer;
        try {
            customer = customerService.getCustomerById(customerId);
        } catch( CustomerNotFoundException e ){
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
            
            System.out.print("Select an option: ");
            int fieldChoice = formIO.getIntInput();

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
 