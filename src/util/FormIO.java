package util;

import java.util.Scanner;

public class FormIO {

    private Scanner sc;

    public FormIO(Scanner sc) {
        this.sc = sc;
    }

    public int getIntInput() {
        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) continue;
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.err.println("Invalid input! Please enter a valid integer.");
            }
        }
    }

    public long getLongInput() {
        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) continue;
            try {
                return Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.err.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    public double getDoubleInput() {
        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) continue;
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.err.println("Invalid input! Please enter a valid decimal.");
            }
        }
    }

    public String getStringInput() {
        while (true) {
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
        }
    }

    public double getValidAmount(){
        double amount;
        while( true ){
            System.out.print("Enter amount : ");
            amount = getDoubleInput();
            if( amount > 0 ) break;
            else System.err.println("Please enter a valid amount!");
        }
        return amount;
    }

    public int getValidCustomerId( ){
        int customerId;
        while( true ){
            System.out.print("Enter Customer ID : ");
            customerId = getIntInput();
            if( customerId > 0 ) break;
            else System.err.println("Please enter a valid Customer ID");
        }
        return customerId;
    }

    public long getValidAccountNumber(){
        long accountNumber;
        while( true ){
            System.out.print("Enter account Number : ");
            accountNumber = getLongInput();
            if( accountNumber == 9 || accountNumber > 1000000000L ) break;
            else System.err.println("Please enter a valid account number");
        }
        return accountNumber;
    }

    public String getValidName( ){
        String name;
        while( true ){
            System.out.print("Enter name : ");
            name = getStringInput();
            if( Validation.isNotEmpty(name) && name.length() > 3 ) break;
            else System.err.println("Please enter a valid name greater than 3 characters!");
        }
        return name;
    }
    
    public int getValidAge(){
        int age;
        while( true ){
            System.out.print("Enter age : ");
            age = getIntInput();
            if( Validation.isValidAge(age) ) break;
            else System.err.println("Please enter a valid age >= 18");
        }
        return age;
    }

    public String getValidMobile(){
        String mobile;
        while( true ){
            System.out.print("Enter Mobile Number: ");
            mobile = getStringInput();
            if( Validation.isValidMobile(mobile) ) break;
            else System.err.println("Please enter a valid mobile number");
        }
        return mobile;
    }

    public String getValidEmail(){
        String email;
            while( true ){
                System.out.print("Enter Email : ");
                email = getStringInput();
                if( Validation.isValidEmail(email) ) break;
                else System.err.println("Please enter a valid email address");
            }
            return email;
    }

    public String getValidAddress(){
        String address;
        while( true ){
            System.out.print("Enter Address : ");
            address = getStringInput();
            if( Validation.isNotEmpty(address) ) break;
            else System.err.println("Please enter a valid address");
        }
        return address;
    }

}
