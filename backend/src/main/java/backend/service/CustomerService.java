package backend.service;

import backend.entity.Customer;
import backend.exeption.NotFoundException;

import java.util.List;

public interface CustomerService {

    Customer getCustomer(Long id) throws NotFoundException;

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer customer) throws NotFoundException;

    void deleteCustomer(Long id);

    List<Customer> getCustomers();

    void deleteCustomers();
}
