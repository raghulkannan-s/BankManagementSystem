package repository;

import enums.ACCOUNT_STATUS;
import java.util.Map;
import model.account.Account;

public class AccountRepository {


    Map<Long, Account> accounts;

    public AccountRepository(Map<Long, Account> accounts) {
        this.accounts = accounts;
    }

    public Account getAccountByNumber(long accountNumber) {
        return accounts.get(accountNumber);
    }

    public void addAccount(Account account) {
        account.generateAccountNumber();
        accounts.put(account.getAccountNumber(), account);
    }

    public void closeAccount(long accountNumber){
        Account account = getAccountByNumber(accountNumber);
        account.setAccountStatus(ACCOUNT_STATUS.INACTIVE);
    }



    





}
