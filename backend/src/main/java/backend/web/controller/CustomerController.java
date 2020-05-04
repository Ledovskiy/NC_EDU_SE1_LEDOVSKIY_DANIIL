package backend.web.controller;

import backend.dto.CustomerDto;
import backend.entity.Customer;
import backend.exeption.NotFoundException;
import backend.mapper.CustomerMapper;
import backend.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper mapper;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerMapper mapper) {
        this.customerService = customerService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("id") Long id) throws NotFoundException {
        Customer customer = customerService.getCustomer(id);
        CustomerDto customerDto = mapper.toDto(customer);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CustomerDto>> getCustomers() {
        List<Customer> customer = customerService.getCustomers();
        List<CustomerDto> customerDto = customer.stream().map((mapper::toDto)).collect(Collectors.toList());
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = mapper.toEntity(customerDto);
        Customer savedCustomer = customerService.saveCustomer(customer);
        CustomerDto savedCustomerDto = mapper.toDto(savedCustomer);
        return new ResponseEntity<>(savedCustomerDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerDto customerDto) {
        Customer customer = mapper.toEntity(customerDto);
        Customer updatedCustomer = customerService.updateCustomer(id, customer);
        CustomerDto updatedCustomerDto = mapper.toDto(updatedCustomer);
        return new ResponseEntity<>(updatedCustomerDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable("id") Long id) throws NotFoundException {
        this.customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<CustomerDto> deleteCustomer() {
        this.customerService.deleteCustomers();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
