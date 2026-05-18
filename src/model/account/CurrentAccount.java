package model.account;

import enums.ACCOUNT_TYPE;

public class CurrentAccount extends Account {

    public CurrentAccount(int customerId, double balance, ACCOUNT_TYPE account_type) {
        super(customerId, balance, account_type, 1000.0);
    }
    
}
