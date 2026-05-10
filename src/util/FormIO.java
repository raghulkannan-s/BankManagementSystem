package util;

import java.util.Scanner;

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


}
