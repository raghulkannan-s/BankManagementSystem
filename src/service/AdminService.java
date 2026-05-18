
package service;

import java.util.List;
import model.Customer;
import model.account.Account;

public class AdminService {

    private CustomerService customerService;
    private AccountService accountService;


    public AdminService(CustomerService customerService, AccountService accountService){
        this.customerService = customerService;
        this.accountService = accountService;
    }

    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomers();
    }

    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    public void blockAccount( Account account ){
        accountService.closeAccount(account.getAccountNumber());
    }

    public void unblockAccount( Account account ){
        accountService.openAccount(account.getAccountNumber());
    }

    public double viewTotalBalance(){
        return accountService.getTotalBankBalance();
    }

}
