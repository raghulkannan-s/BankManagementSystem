package model;

import enums.TRANSACTION_TYPE;
import util.IdGenerator;

public class Transaction {

    private final int id;
    private final Long transaction_Account_Number;
    private final double transaction_amount;
    private final TRANSACTION_TYPE transaction_type;


    public Transaction( Long accountNumber, double amount, TRANSACTION_TYPE transaction_type ){
        this.id = IdGenerator.generateTransactionId();
        this.transaction_Account_Number = accountNumber;
        this.transaction_amount = amount;
        this.transaction_type = transaction_type;
    }


    public int getId() {
        return id;
    }


    public Long getTransaction_Account_Number() {
        return transaction_Account_Number;
    }


    public double getTransaction_amount() {
        return transaction_amount;
    }


    public TRANSACTION_TYPE getTransaction_type() {
        return transaction_type;
    }


    @Override
    public String toString() {
        return String.format(
            "| Txn ID: %-5d | Type: %-10s | Account: %-12d | Amount: $%10.2f |",
            id, transaction_type, transaction_Account_Number, transaction_amount
        );
    }

    
    


}
