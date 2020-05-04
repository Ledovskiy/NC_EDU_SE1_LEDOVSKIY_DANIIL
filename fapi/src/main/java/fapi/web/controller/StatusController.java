package fapi.web.controller;

import fapi.client.StatusClient;
import fapi.dto.StatusDto;
import fapi.exeption.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/fapi/v1/status")
public class StatusController {


    private final StatusClient statusClient;

    @Autowired
    public StatusController(StatusClient statusClient) {
        this.statusClient = statusClient;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDto> getStatus(@PathVariable("id") Long id) throws NotFoundException {
        StatusDto statusDto = statusClient.getStatusById(id);
        return new ResponseEntity<>(statusDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<StatusDto[]> getStatuses() {
        StatusDto[] statusDto = statusClient.getStatuses();
        return new ResponseEntity<>(statusDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StatusDto> saveStatus(@RequestBody StatusDto statusDto) {
        StatusDto savedStatusDto = statusClient.saveStatus(statusDto);
        return new ResponseEntity<>(savedStatusDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusDto> updateStatus(@PathVariable("id") Long id, @RequestBody StatusDto statusDto) {
        StatusDto updatedStatusDto = statusClient.putStatus(id, statusDto);
        return new ResponseEntity<>(updatedStatusDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteStatus(@PathVariable Long id) throws NotFoundException {
        statusClient.deleteStatus(id);
    }
}
