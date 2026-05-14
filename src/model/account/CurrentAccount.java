package model.account;

import enums.ACCOUNT_TYPE;

public class CurrentAccount extends Account {

    public CurrentAccount(int customerId, double minimumBalance, ACCOUNT_TYPE account_type) {
        super(customerId, minimumBalance, account_type);
    }
    
}
