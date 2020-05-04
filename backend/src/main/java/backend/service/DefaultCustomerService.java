package backend.service;

import backend.entity.Customer;
import backend.exeption.NotFoundException;
import backend.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefaultCustomerService implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public DefaultCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomer(Long id) throws NotFoundException {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new NotFoundException("Customer with id: " + id + " was not found");
        }
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) throws NotFoundException {
        Optional<Customer> customerToUpdateOptional = customerRepository.findById(id);
        if (customerToUpdateOptional.isPresent()) {
            Customer customerToUpdate = this.updateCustomerFields(customerToUpdateOptional.get(), customer);
            return customerRepository.save(customerToUpdate);
        } else {
            throw new NotFoundException("Customer with id: " + id + " was not found");
        }
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomers() {
        customerRepository.deleteAll();
    }

    private Customer updateCustomerFields(Customer customerToUpdate, Customer newCustomer) {
        if (newCustomer.getLogin() != null) {
            customerToUpdate.setLogin(newCustomer.getLogin());
        }

        if (newCustomer.getPassword() != null) {
            customerToUpdate.setPassword(newCustomer.getPassword());
        }

        if (newCustomer.getEmail() != null) {
            customerToUpdate.setEmail(newCustomer.getEmail());
        }


        customerToUpdate.setRole(newCustomer.getRole());
        customerToUpdate.setStatus(newCustomer.getStatus());

        return customerToUpdate;
    }
}

