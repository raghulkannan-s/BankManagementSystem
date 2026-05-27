package service;

import enums.TRANSACTION_TYPE;
import exception.InsufficientBalanceException;
import model.account.Account;

public class TransactionService {

    TransactionHistoryService transactionHistoryService;
    private final AccountService accountService;

    public TransactionService(AccountService accountService, TransactionHistoryService transactionHistoryService) {
        this.accountService = accountService;
        this.transactionHistoryService = transactionHistoryService;
    }

    public double deposit(Account account, double amount){

        account.setBalance(account.getBalance() + amount);
        transactionHistoryService.addLog( account.getAccountNumber(), amount, TRANSACTION_TYPE.CREDIT );
        return account.getBalance();

    }

    public double withdraw(Account account, double amount){

        if( (account.getBalance() - account.getMinimumBalance()) < amount ){
            throw new InsufficientBalanceException("Your Balance is too low to withdraw!");
        }

        account.setBalance(account.getBalance()-amount);
        transactionHistoryService.addLog( account.getAccountNumber(), amount, TRANSACTION_TYPE.DEBIT );
        return account.getBalance();
        
    }
    
    public void transfer( Account fromAccount, Account toAccount, double amount ){
        withdraw(fromAccount, amount);
        deposit(toAccount, amount);
        transactionHistoryService.addLog( fromAccount.getAccountNumber(), amount, TRANSACTION_TYPE.DEBIT );
        transactionHistoryService.addLog( toAccount.getAccountNumber(), amount, TRANSACTION_TYPE.CREDIT );


    }


}
