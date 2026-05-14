package util;

public class IdGenerator {

    private static int customerCounter = 1000;
    private static long accountCounter = 1000000000L;
    private static int transactionCounter = 1;

    public static int generateCustomerId() {
        return ++customerCounter;
    }

    public static long generateAccountNumber() {
        return ++accountCounter;
    }

    public static int generateTransactionId() {
        return ++transactionCounter;
    }
}