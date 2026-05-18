package model.account;

import enums.ACCOUNT_STATUS;
import enums.ACCOUNT_TYPE;
import util.IdGenerator;

public abstract class Account {

    private int CustomerId;
    private long accountNumber;
    private double balance;
    private ACCOUNT_STATUS accountStatus;
    private ACCOUNT_TYPE account_type;
    private double minimumBalance;

    public Account(int CustomerId, double balance, ACCOUNT_TYPE account_type, double minimumBalance) {
        this.CustomerId = CustomerId;
        this.balance = balance;
        this.account_type = account_type;
        this.minimumBalance = minimumBalance;
        this.accountStatus = ACCOUNT_STATUS.ACTIVE;
    }

    public void generateAccountNumber() {
        this.accountNumber = IdGenerator.generateAccountNumber();
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ACCOUNT_STATUS getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(ACCOUNT_STATUS accountStatus) {
        this.accountStatus = accountStatus;
    }

    public ACCOUNT_TYPE getAccount_type() {
        return account_type;
    }

    public void setAccount_type(ACCOUNT_TYPE account_type) {
        this.account_type = account_type;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    @Override
    public String toString() {
        return String.format(
            "| Account No: %-12d | Type: %-8s | Status: %-8s | Balance: $%.2f | Min Bal: $%.2f | Cust ID: %d |",
            accountNumber, account_type, accountStatus, balance, minimumBalance, CustomerId
        );
    }
}

