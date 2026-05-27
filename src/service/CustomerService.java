package service;

import dto.Result;
import exception.CustomerNotFoundException;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import repository.CustomerRepository;

public class CustomerService {

    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Result createAndSaveCustomer(String name, int age, String mobile, String email, String address) {
        Customer customer = new Customer(name, age, mobile, email, address);
        return customerRepository.addNewCustomer(customer);
    }

    public Result addNewCustomer(Customer customer){
        return customerRepository.addNewCustomer(customer);
    }

    public Customer getCustomerById( int customerId ){
        Customer customer = customerRepository.getCustomerById(customerId);
        if( customer == null ){
            throw new CustomerNotFoundException("Customer ID doesn't Exist");
        }
        return customer;
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
