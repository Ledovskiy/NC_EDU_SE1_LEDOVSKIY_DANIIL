package fapi.web.controller;

import fapi.client.CustomerClient;
import fapi.dto.CustomerDto;
import fapi.exeption.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/fapi/v1/customers")
public class CustomerController {


    private final CustomerClient customerClient;

    @Autowired
    public CustomerController(CustomerClient customerClient) {
        this.customerClient = customerClient;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("id") Long id) throws NotFoundException {
        CustomerDto customerDto = customerClient.getCustomer(id);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<CustomerDto[]> getCustomers() {
        CustomerDto[] customersDto = customerClient.getCustomers();
        return new ResponseEntity<>(customersDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto savedCustomerDto = customerClient.saveCustomer(customerDto);
        return new ResponseEntity<>(savedCustomerDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerDto customerDto) {
        CustomerDto updatedCustomerDto = customerClient.putCustomer(id, customerDto);
        return new ResponseEntity<>(updatedCustomerDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) throws NotFoundException {
        customerClient.deleteCustomer(id);
    }
}
