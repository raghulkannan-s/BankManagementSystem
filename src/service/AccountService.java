package service;

import enums.ACCOUNT_TYPE;
import factory.AccountFactory;
import java.util.List;
import model.account.Account;
import repository.AccountRepository;

public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountFactory accountFactory;

    public AccountService(AccountRepository accountRepository, AccountFactory accountFactory) {
        this.accountRepository = accountRepository;
        this.accountFactory = accountFactory;
    }

    public Account createAndSaveAccount(int customerId, double initialDeposit, ACCOUNT_TYPE account_type) {
        Account account = accountFactory.createAccount(customerId, initialDeposit, account_type);
        if (account != null) {
            accountRepository.addAccount(account);
        }
        return account;
    }

    public Account getAccountByNumber(long accountNumber){
        return accountRepository.getAccountByNumber(accountNumber);
    }

     public List<Account> getAllAccounts(){
        return accountRepository.getAllAccounts();
    }

    public void addNewAccount(Account account) {
        accountRepository.addAccount(account);
    }

    public void closeAccount(long accountNumber){
        accountRepository.closeAccount(accountNumber);
    }

    public void openAccount( long accountNumber ){
        accountRepository.openAccount(accountNumber);
    }

    public boolean checkIfHasAmount( Account account, double amount ){
        return account.getBalance() >= amount;
    }

    public double getTotalBankBalance(){
        return accountRepository.viewTotalBalance();
    }

}
