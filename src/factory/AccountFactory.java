package factory;

import enums.ACCOUNT_TYPE;
import model.account.Account;
import model.account.CurrentAccount;
import model.account.SavingAccount;

public class AccountFactory {

    public Account createAccount(int customerId, double minimumBalance,  ACCOUNT_TYPE account_type){

        Account account = null;

        switch (account_type){
            case ACCOUNT_TYPE.SAVINGS :
                account =  new SavingAccount(customerId, minimumBalance, account_type);
                break;
            case ACCOUNT_TYPE.CURRENT:
                account = new CurrentAccount(customerId, minimumBalance, account_type);
                break;
            default:
                return null;
        }

        return account;

    }

}
