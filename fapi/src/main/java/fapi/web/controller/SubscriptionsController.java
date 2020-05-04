package fapi.web.controller;

import fapi.client.SubscriptionsClient;
import fapi.dto.SubscriptionsDto;
import fapi.exeption.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/fapi/v1/subscriptions")
public class SubscriptionsController {


    private final SubscriptionsClient subscriptionsClient;

    @Autowired
    public SubscriptionsController(SubscriptionsClient subscriptionsClient) {
        this.subscriptionsClient = subscriptionsClient;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionsDto> getSubscription(@PathVariable("id") Long id) throws NotFoundException {
        SubscriptionsDto subscriptionsDto = subscriptionsClient.getSubscriptionById(id);
        return new ResponseEntity<>(subscriptionsDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<SubscriptionsDto[]> getSubscriptions() {
        SubscriptionsDto[] subscriptionsDto = subscriptionsClient.getSubscriptions();
        return new ResponseEntity<>(subscriptionsDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SubscriptionsDto> saveSubscription(@RequestBody SubscriptionsDto subscriptionsDto) {
        SubscriptionsDto savedSubscriptionsDto = subscriptionsClient.saveSubscription(subscriptionsDto);
        return new ResponseEntity<>(savedSubscriptionsDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionsDto> updateSubscription(@PathVariable("id") Long id, @RequestBody SubscriptionsDto subscriptionsDto) {
        SubscriptionsDto updatedSubscriptionsDto = subscriptionsClient.putSubscription(id, subscriptionsDto);
        return new ResponseEntity<>(updatedSubscriptionsDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteSubscription(@PathVariable Long id) throws NotFoundException {
        subscriptionsClient.deleteSubscription(id);
    }
}
