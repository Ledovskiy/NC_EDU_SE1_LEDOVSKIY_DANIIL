package backend.web.controller;

import backend.dto.StatusDto;
import backend.entity.Status;
import backend.exeption.NotFoundException;
import backend.mapper.StatusMapper;
import backend.service.StatusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/statuses")
public class StatusController {

    private final StatusService statusService;
    private final StatusMapper mapper;

    @Autowired
    public StatusController(StatusService statusService, StatusMapper mapper) {
        this.statusService = statusService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDto> getStatus(@PathVariable("id") Long id) throws NotFoundException {
        Status status = statusService.getStatus(id);
        StatusDto statusDto = mapper.toDto(status);
        return new ResponseEntity<>(statusDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<StatusDto>> getStatus() {
        List<Status> status = statusService.getStatuses();
        List<StatusDto> statusDto = status.stream().map((mapper::toDto)).collect(Collectors.toList());
        return new ResponseEntity<>(statusDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StatusDto> saveStatus(@RequestBody StatusDto statusDto) {
        Status status = mapper.toEntity(statusDto);
        Status savedStatus = statusService.saveStatus(status);
        StatusDto savedStatusDto = mapper.toDto(savedStatus);
        return new ResponseEntity<>(savedStatusDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusDto> updateStatus(@PathVariable("id") Long id, @RequestBody StatusDto statusDto) {
        Status status = mapper.toEntity(statusDto);
        Status updatedStatus = statusService.updateStatus(id, status);
        StatusDto updatedStatusDto = mapper.toDto(updatedStatus);
        return new ResponseEntity<>(updatedStatusDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StatusDto> deleteStatus(@PathVariable("id") Long id) throws NotFoundException {
        this.statusService.deleteStatus(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<StatusDto> deleteStatus() {
        this.statusService.deleteStatuses();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
