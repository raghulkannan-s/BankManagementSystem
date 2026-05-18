package repository;

import dto.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Customer;

public class CustomerRepository {

    Map<Integer, Customer> customers;

    public CustomerRepository(Map<Integer, Customer> customers) {
        this.customers = customers;
    }

    public Result addNewCustomer( Customer customer ){

        customer.generateCustomerId();
        customers.put( customer.getCustomerId(), customer );
        return new Result(true, customer.getName() + " - Customer Added Successfully \n Customer ID : " + customer.getCustomerId());
    
    }

    public List<Customer> getAllCustomers(){
        return new ArrayList<>(customers.values());
    }

    public Customer getCustomerById(int customerId ){
        if( !customers.containsKey(customerId) ) return null;
        return customers.get(customerId);
    }

    public void updateCustomerDetails(int customerId, Customer customer) {
        customers.put(customerId, customer);
    }


}
