package util;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {

    private static AtomicInteger customerCounter = new AtomicInteger(1000);
    private static AtomicLong accountCounter = new AtomicLong(1000000000L);
    private static AtomicInteger transactionCounter = new AtomicInteger(1);

    public static int generateCustomerId() {
        return customerCounter.incrementAndGet();
    }

    public static long generateAccountNumber() {
        return accountCounter.incrementAndGet();
    }

    public static int generateTransactionId() {
        return transactionCounter.incrementAndGet();
    }
}