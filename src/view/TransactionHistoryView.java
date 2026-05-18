
package view;

import java.util.List;
import java.util.Scanner;
import model.Transaction;
import service.TransactionHistoryService;

public class TransactionHistoryView {

    Scanner sc;
    TransactionHistoryService transactionHistoryService;

    public TransactionHistoryView(Scanner sc, TransactionHistoryService transactionHistoryService) {
        this.sc = sc;
        this.transactionHistoryService = transactionHistoryService;
    }

    
    public void start(){

        while( true ){

            System.out.println("1. Show All Transaction Logs");
            System.out.println("6. Go Back to main menu");
            
            System.out.println("Enter you choice : ");
            
            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch(choice){
                case 1 :
                    showAllLogs();
                    break;
                case 6 :
                    return;
                default:
                    System.err.println("Please Enter a valid choice!");
            }
        }

    }

    public void showAllLogs(){
        List<Transaction> transactions = transactionHistoryService.showAllLogs();
        for( Transaction transaction : transactions ){
            System.out.println(transaction.toString());
        }
    }

}
