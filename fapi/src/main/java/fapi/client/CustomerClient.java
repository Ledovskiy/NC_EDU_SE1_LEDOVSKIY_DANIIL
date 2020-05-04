package fapi.client;

import fapi.dto.CustomerDto;
import fapi.exeption.NotFoundException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerClient {

    private final RestTemplate restTemplate = new RestTemplate();

    private final HttpHeaders headers = new HttpHeaders();

    private final String customersUrl = "http://localhost:8081/api/v1/customers";


    public CustomerDto[] getCustomers() {
        ResponseEntity<CustomerDto[]> response = restTemplate.getForEntity(this.customersUrl, CustomerDto[].class);
        return response.getBody();
    }

    public void deleteCustomer(Long id) throws NotFoundException {
        restTemplate.delete(this.customersUrl + "/" + id, CustomerDto.class);
    }

    public CustomerDto saveCustomer(CustomerDto customerDto) {
        HttpEntity<CustomerDto> entity = new HttpEntity<>(customerDto, this.headers);
        return this.restTemplate.exchange(this.customersUrl, HttpMethod.POST, entity, CustomerDto.class).getBody();
    }

    public CustomerDto putCustomer(Long id, CustomerDto customerDto) {
        HttpEntity<CustomerDto> entity = new HttpEntity<>(customerDto, this.headers);
        return this.restTemplate.exchange(this.customersUrl + "/" + id, HttpMethod.PUT, entity, CustomerDto.class).getBody();
    }

    public CustomerDto getCustomer(Long id) {
        return this.restTemplate.getForObject(this.customersUrl +  "/" + id, CustomerDto.class);
    }
}
