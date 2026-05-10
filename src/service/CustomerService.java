package service;

import dto.Result;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import repository.CustomerRepository;

public class CustomerService {

    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Result addNewCustomer(Customer customer){
        return customerRepository.addNewCustomer(customer);
    }

    public Customer getCustomerById( int customerId ){
        return customerRepository.getCustomerById(customerId);
    }

    public Result updateCustomerDetails( int customerId, Customer customer ){

        customerRepository.updateCustomerDetails(customerId, customer);
        return new Result( true, "Customer Detail Updated" );
    
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }
    
    public List<Customer> searchCustomerByName( String name ){

        List<Customer> customers = getAllCustomers();
        if( customers == null ) return null;

        List<Customer> result = new ArrayList<>();

        for( Customer customer : customers ){
            if( customer.getName().contains(name) ){
                result.add(customer);
            }
        }

        return result;
    }

}
