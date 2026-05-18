package service;

import enums.TRANSACTION_TYPE;
import java.util.List;
import model.Transaction;
import repository.TransactionHistoryRepository;

public class TransactionHistoryService {


    TransactionHistoryRepository transactionHistoryRepository;

    public TransactionHistoryService(TransactionHistoryRepository transactionHistoryRepository){
        this.transactionHistoryRepository = transactionHistoryRepository;
    }

    public List<Transaction> showAllLogs(){
        return transactionHistoryRepository.showTransactions();
    }

    public void addLog(Long accountNumber, double amount, TRANSACTION_TYPE transaction_type){
        Transaction transaction = new Transaction(accountNumber, amount, transaction_type);
        transactionHistoryRepository.addTransaction(transaction);
    }


}
