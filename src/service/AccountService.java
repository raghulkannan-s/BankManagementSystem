package service;

import model.account.Account;
import repository.AccountRepository;

public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccountByNumber(long accountNumber){
        return accountRepository.getAccountByNumber(accountNumber);
    }

    public void addNewAccount(Account account) {
        accountRepository.addAccount(account);
    }

    public void closeAccount(long accountNumber){
        accountRepository.closeAccount(accountNumber);
    }




}
