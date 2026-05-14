package util;

import java.util.Scanner;
import model.Customer;
import model.account.Account;
import service.AccountService;
import service.CustomerService;

public class FormIO {

    private Scanner sc;

    public FormIO(Scanner sc) {
        this.sc = sc;
    }

    public int getValidCustomerId( ){
        int customerId;
        while( true ){
            System.out.print("Enter Customer ID : ");
            customerId = sc.nextInt();
            sc.nextLine();

            if( customerId > 0 ) break;
            else System.err.println("Please enter a valid Customer ID");
        }
        return customerId;
    }

    public long getValidAccountNumber(){

        long accountNumber;

        while( true ){
            System.out.print("Enter account Number : ");
            accountNumber = sc.nextInt();
            sc.nextLine();

            if( accountNumber == 9 || accountNumber > 1000000000L ) break;
            else System.err.println("Please enter a valid account number");
        }
        return accountNumber;
    }

    public String getValidName( ){
        String name;
        while( true ){
            System.out.print("Enter name : ");
            name = sc.nextLine();

            if( Validation.isNotEmpty(name) && name.length() > 3 ) break;
            else System.err.println("Please enter a valid name");
        }

        return name;
    }
    
    public int getValidAge(){
        int age;
        while( true ){
            System.out.print("Enter age : ");
            age = sc.nextInt();
            sc.nextLine();

            if( Validation.isValidAge(age) ) break;
            else System.err.println("Please enter a valid age >= 18");
        }
        return age;
    }

    public String getValidMobile(){
        String mobile;
        while( true ){

            System.out.print("Enter Mobile Number: ");
            mobile = sc.next();

            if( Validation.isValidMobile(mobile) ) break;
            else System.err.println("Please enter a valid mobile number");
        }
        return mobile;
    }

    public String getValidEmail(){
        String email;
            while( true ){
                System.out.print("Enter Email : ");
                email = sc.next();

                if( Validation.isValidEmail(email) ) break;
                else System.err.println("Please enter a valid email address");
            }
            return email;
    }

    public String getValidAddress(){
        String address;

        while( true ){
            System.out.print("Enter Address : ");
            address = sc.nextLine();

            if( Validation.isNotEmpty(address) ) break;
            else System.err.println("Please enter a valid address");
        }
        return address;
    }

    public int getExistingValidCustomerId(CustomerService customerService){

        int customerId;

        while( true ){
            
            System.out.println("Press 9 to Exit!");
            System.out.println("Enter Customer ID : ");

            customerId = getValidCustomerId();
            
            if( customerId == 9 ) return 0;

            Customer customer = customerService.getCustomerById(customerId);
            
            if( customer == null ) System.out.println("Customer ID doesn't Exist"); 
            else {
                System.out.println("Welcome "+ customer.getName());
                break;
            }
        }
        return customerId;
    }
    
    public Account getExistingValidAccount(AccountService accountService){

        Account account;

        while( true ){
            
            System.out.println("Press 9 to Exit!");
            System.out.println("Enter Account Number : ");

            long accountNumber = getValidAccountNumber();
            
            if( accountNumber == 9 ) return null;

            account = accountService.getAccountByNumber(accountNumber);
            
            if( account == null ) System.out.println("Account Number doesn't Exist"); 
            else {
                break;
            }
        }
        return account;
    }

}
