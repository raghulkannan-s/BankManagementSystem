package factory;

import enums.ACCOUNT_TYPE;
import model.account.Account;
import model.account.CurrentAccount;
import model.account.SavingAccount;

public class AccountFactory {

    public Account createAccount(int customerId, double initialDeposit,  ACCOUNT_TYPE account_type){

        Account account;

        switch (account_type){
            case ACCOUNT_TYPE.SAVINGS -> account =  new SavingAccount(customerId, initialDeposit, account_type);
            case ACCOUNT_TYPE.CURRENT -> account = new CurrentAccount(customerId, initialDeposit, account_type);
            default -> {
                return null;
            }
        }

        return account;

    }

}
