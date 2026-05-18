package repository;

import java.util.List;
import model.Transaction;

public class TransactionHistoryRepository {

    List<Transaction> logs;

    public TransactionHistoryRepository(List<Transaction> logs) {
        this.logs = logs;
    }

    public List<Transaction> showTransactions(){
        return logs;
    }

    public void addTransaction(Transaction transaction){
        logs.add(transaction);
    }

    

}
