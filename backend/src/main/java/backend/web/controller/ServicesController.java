package backend.web.controller;

import backend.dto.ServicesDto;
import backend.entity.Services;
import backend.exeption.NotFoundException;
import backend.mapper.ServicesMapper;
import backend.service.ServicesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/services")
public class ServicesController {

    private final ServicesService servicesService;
    private final ServicesMapper mapper;

    @Autowired
    public ServicesController(ServicesService servicesService, ServicesMapper mapper) {
        this.servicesService = servicesService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicesDto> getServices(@PathVariable("id") Long id) throws NotFoundException {
        Services services = servicesService.getService(id);
        ServicesDto servicesDto = mapper.toDto(services);
        return new ResponseEntity<>(servicesDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ServicesDto>> getServices() {
        List<Services> services = servicesService.getServices();
        List<ServicesDto> servicesDto = services.stream().map((mapper::toDto)).collect(Collectors.toList());
        return new ResponseEntity<>(servicesDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ServicesDto> saveServices(@RequestBody ServicesDto servicesDto) {
        Services services = mapper.toEntity(servicesDto);
        Services savedServices = servicesService.saveService(services);
        ServicesDto savedServicesDto = mapper.toDto(savedServices);
        return new ResponseEntity<>(savedServicesDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicesDto> updateServices(@PathVariable("id") Long id, @RequestBody ServicesDto servicesDto) {
        Services services = mapper.toEntity(servicesDto);
        Services updatedServices = servicesService.updateService(id, services);
        ServicesDto updatedServicesDto = mapper.toDto(updatedServices);
        return new ResponseEntity<>(updatedServicesDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ServicesDto> deleteServices(@PathVariable("id") Long id) throws NotFoundException {
        this.servicesService.deleteService(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<ServicesDto> deleteServices() {
        this.servicesService.deleteServices();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
