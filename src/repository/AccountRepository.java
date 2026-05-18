package repository;

import enums.ACCOUNT_STATUS;
import java.util.ArrayList;
import java.util.List;
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

    public List<Account> getAllAccounts(){
        return new ArrayList<>(accounts.values());
    }
 
    public void addAccount(Account account) {
        account.generateAccountNumber();
        accounts.put(account.getAccountNumber(), account);
    }

    public void closeAccount(long accountNumber){
        Account account = getAccountByNumber(accountNumber);
        if( account.getAccountStatus() == ACCOUNT_STATUS.INACTIVE ) return;
        account.setAccountStatus(ACCOUNT_STATUS.INACTIVE);
    }

    public void openAccount(long accountNumber){
        Account account = getAccountByNumber(accountNumber);
        if( account.getAccountStatus() == ACCOUNT_STATUS.ACTIVE ) return;
        account.setAccountStatus(ACCOUNT_STATUS.ACTIVE);
    }

    public double viewTotalBalance(){

        double totalBalance = 0;

        for( Account account : accounts.values() ){
            totalBalance += account.getBalance();
        }

        return totalBalance;
    }





    





}
