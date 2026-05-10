package util;

public class Validation {
    
    public static boolean isNotEmpty(String data){
        return ( data != null && data != "" );
    }

    public static boolean isValidAge( int age ){
        return ( age >= 18 );
    }

    public static boolean isValidMobile(String mobile){
        return ( isNotEmpty(mobile) && mobile.matches("^[0-9]{10}$") );
    }

    public static boolean isValidEmail( String email ){
        return ( isNotEmpty(email) && email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") );
    }



}
