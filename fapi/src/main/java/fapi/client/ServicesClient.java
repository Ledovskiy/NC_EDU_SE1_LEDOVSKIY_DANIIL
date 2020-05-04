package fapi.client;

import fapi.dto.ServicesDto;
import fapi.exeption.NotFoundException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServicesClient {

    private final RestTemplate restTemplate = new RestTemplate();

    private final HttpHeaders headers = new HttpHeaders();

    private final String servicesUrl = "http://localhost:8081/api/v1/services";

    public ServicesDto[] getServices() {
        ResponseEntity<ServicesDto[]> response = restTemplate.getForEntity(this.servicesUrl, ServicesDto[].class);
        return response.getBody();
    }

    public void deleteService(Long id) throws NotFoundException {
        restTemplate.delete(this.servicesUrl + "/" + id, ServicesDto.class);
    }

    public ServicesDto saveService(ServicesDto serviceDto) {
        HttpEntity<ServicesDto> entity = new HttpEntity<>(serviceDto, this.headers);
        return this.restTemplate.exchange(this.servicesUrl, HttpMethod.POST, entity, ServicesDto.class).getBody();
    }

    public ServicesDto putService(Long id, ServicesDto serviceDto) {
        HttpEntity<ServicesDto> entity = new HttpEntity<>(serviceDto, this.headers);
        return this.restTemplate.exchange(this.servicesUrl + "/" + id, HttpMethod.PUT, entity, ServicesDto.class).getBody();
    }

    public ServicesDto getServiceById(Long id) {
        return this.restTemplate.getForObject(this.servicesUrl +  "/" + id, ServicesDto.class);
    }
}
