package fapi.client;

import fapi.dto.StatusDto;
import fapi.exeption.NotFoundException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StatusClient {

    private final RestTemplate restTemplate = new RestTemplate();

    private final HttpHeaders headers = new HttpHeaders();

    private final String statusUrl = "http://localhost:8081/api/v1/statuses";

    public StatusDto[] getStatuses() {
        ResponseEntity<StatusDto[]> response = restTemplate.getForEntity(this.statusUrl, StatusDto[].class);
        return response.getBody();
    }

    public void deleteStatus(Long id) throws NotFoundException {
        restTemplate.delete(this.statusUrl + "/" + id, StatusDto.class);
    }

    public StatusDto saveStatus(StatusDto statusDto) {
        HttpEntity<StatusDto> entity = new HttpEntity<>(statusDto, this.headers);
        return this.restTemplate.exchange(this.statusUrl, HttpMethod.POST, entity, StatusDto.class).getBody();
    }

    public StatusDto putStatus(Long id, StatusDto statusDto) {
        HttpEntity<StatusDto> entity = new HttpEntity<>(statusDto, this.headers);
        return this.restTemplate.exchange(this.statusUrl + "/" + id, HttpMethod.PUT, entity, StatusDto.class).getBody();
    }

    public StatusDto getStatusById(Long id) {
        return this.restTemplate.getForObject(this.statusUrl + "/" + id, StatusDto.class);
    }
}
