package model.account;

import enums.ACCOUNT_STATUS;
import enums.ACCOUNT_TYPE;
import util.IdGenerator;

public abstract class Account {

    private int CustomerId;
    private long accountNumber;
    private double balance;
    private ACCOUNT_STATUS accountStatus;
    private double minimumBalance;
    private ACCOUNT_TYPE account_type;

    public Account(int CustomerId, double balance, ACCOUNT_TYPE account_type) {
        this.CustomerId = CustomerId;
        this.balance = balance;
        this.account_type = account_type;
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

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public ACCOUNT_TYPE getAccount_type() {
        return account_type;
    }

    public void setAccount_type(ACCOUNT_TYPE account_type) {
        this.account_type = account_type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Account{");
        sb.append("CustomerId=").append(CustomerId);
        sb.append(", accountNumber=").append(accountNumber);
        sb.append(", balance=").append(balance);
        sb.append(", accountStatus=").append(accountStatus);
        sb.append(", minimumBalance=").append(minimumBalance);
        sb.append(", account_type=").append(account_type);
        sb.append('}');
        return sb.toString();
    }

}

