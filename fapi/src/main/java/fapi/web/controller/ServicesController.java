package fapi.web.controller;

import fapi.client.ServicesClient;
import fapi.dto.ServicesDto;
import fapi.exeption.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/fapi/v1/services")
public class ServicesController {


    private final ServicesClient servicesClient;

    @Autowired
    public ServicesController(ServicesClient servicesClient) {
        this.servicesClient = servicesClient;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicesDto> getService(@PathVariable("id") Long id) throws NotFoundException {
        ServicesDto servicesDto = servicesClient.getServiceById(id);
        return new ResponseEntity<>(servicesDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<ServicesDto[]> getServices() {
        ServicesDto[] servicesDto = servicesClient.getServices();
        return new ResponseEntity<>(servicesDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ServicesDto> saveService(@RequestBody ServicesDto servicesDto) {
        ServicesDto savedServicesDto = servicesClient.saveService(servicesDto);
        return new ResponseEntity<>(savedServicesDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicesDto> updateService(@PathVariable("id") Long id, @RequestBody ServicesDto servicesDto) {
        ServicesDto updatedServicesDto = servicesClient.putService(id, servicesDto);
        return new ResponseEntity<>(updatedServicesDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id) throws NotFoundException {
        servicesClient.deleteService(id);
    }
}
