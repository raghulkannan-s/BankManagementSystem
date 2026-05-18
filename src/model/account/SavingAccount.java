package model.account;

import enums.ACCOUNT_TYPE;

public class SavingAccount extends Account {

    public SavingAccount(int customerId, double balance, ACCOUNT_TYPE account_type) {
        super(customerId, balance, account_type, 500.0);
    }

    
    
}
