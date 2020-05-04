package backend.web.controller;

import backend.dto.SubscriptionsDto;
import backend.entity.Subscriptions;
import backend.exeption.NotFoundException;
import backend.mapper.SubscriptionsMapper;
import backend.service.SubscriptionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/subscriptions")
public class SubscriptionsController {

    private final SubscriptionsService subscriptionsService;
    private final SubscriptionsMapper mapper;

    @Autowired
    public SubscriptionsController(SubscriptionsService subscriptionsService, SubscriptionsMapper mapper) {
        this.subscriptionsService = subscriptionsService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionsDto> getSubscriptions(@PathVariable("id") Long id) throws NotFoundException {
        Subscriptions subscriptions = subscriptionsService.getSubscription(id);
        SubscriptionsDto subscriptionsDto = mapper.toDto(subscriptions);
        return new ResponseEntity<>(subscriptionsDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<SubscriptionsDto>> getSubscriptions() {
        List<Subscriptions> subscriptions = subscriptionsService.getSubscriptions();
        List<SubscriptionsDto> subscriptionsDto = subscriptions.stream().map((mapper::toDto)).collect(Collectors.toList());
        return new ResponseEntity<>(subscriptionsDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SubscriptionsDto> saveSubscriptions(@RequestBody SubscriptionsDto subscriptionsDto) {
        Subscriptions subscriptions = mapper.toEntity(subscriptionsDto);
        Subscriptions savedSubscriptions = subscriptionsService.saveSubscription(subscriptions);
        SubscriptionsDto savedSubscriptionsDto = mapper.toDto(savedSubscriptions);
        return new ResponseEntity<>(savedSubscriptionsDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionsDto> updateSubscriptions(@PathVariable("id") Long id, @RequestBody SubscriptionsDto subscriptionsDto) {
        Subscriptions subscriptions = mapper.toEntity(subscriptionsDto);
        Subscriptions updatedSubscriptions = subscriptionsService.updateSubscription(id, subscriptions);
        SubscriptionsDto updatedSubscriptionsDto = mapper.toDto(updatedSubscriptions);
        return new ResponseEntity<>(updatedSubscriptionsDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SubscriptionsDto> deleteSubscriptions(@PathVariable("id") Long id) throws NotFoundException {
        this.subscriptionsService.deleteSubscription(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<SubscriptionsDto> deleteSubscriptions() {
        this.subscriptionsService.deleteSubscriptions();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
