package fapi.client;

import fapi.dto.SubscriptionsDto;
import fapi.exeption.NotFoundException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SubscriptionsClient {

    private final RestTemplate restTemplate = new RestTemplate();

    private final HttpHeaders headers = new HttpHeaders();

    private final String subscriptionsUrl = "http://localhost:8081/api/v1/subscriptions";

    public SubscriptionsDto[] getSubscriptions() {
        ResponseEntity<SubscriptionsDto[]> response = restTemplate.getForEntity(this.subscriptionsUrl, SubscriptionsDto[].class);
        return response.getBody();
    }

    public void deleteSubscription(Long id) throws NotFoundException {
        restTemplate.delete(this.subscriptionsUrl + "/" + id, SubscriptionsDto.class);
    }

    public SubscriptionsDto saveSubscription(SubscriptionsDto subscriptionsDto) {
        HttpEntity<SubscriptionsDto> entity = new HttpEntity<>(subscriptionsDto, this.headers);
        return this.restTemplate.exchange(this.subscriptionsUrl, HttpMethod.POST, entity, SubscriptionsDto.class).getBody();
    }

    public SubscriptionsDto putSubscription(Long id, SubscriptionsDto subscriptionsDto) {
        HttpEntity<SubscriptionsDto> entity = new HttpEntity<>(subscriptionsDto, this.headers);
        return this.restTemplate.exchange(this.subscriptionsUrl + "/" + id, HttpMethod.PUT, entity, SubscriptionsDto.class).getBody();
    }

    public SubscriptionsDto getSubscriptionById(Long id) {
        return this.restTemplate.getForObject(this.subscriptionsUrl +  "/" + id, SubscriptionsDto.class);
    }
}
