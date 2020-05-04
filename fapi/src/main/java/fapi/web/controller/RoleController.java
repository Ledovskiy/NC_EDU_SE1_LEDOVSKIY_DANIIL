package fapi.web.controller;

import fapi.client.RoleClient;
import fapi.dto.RoleDto;
import fapi.exeption.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/fapi/v1/roles")
public class RoleController {


    private final RoleClient roleClient;

    @Autowired
    public RoleController(RoleClient roleClient) {
        this.roleClient = roleClient;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> getRole(@PathVariable("id") Long id) throws NotFoundException {
        RoleDto roleDto = roleClient.getRoleById(id);
        return new ResponseEntity<>(roleDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<RoleDto[]> getRoles() {
        RoleDto[] rolesDto = roleClient.getRoles();
        return new ResponseEntity<>(rolesDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleDto> saveRole(@RequestBody RoleDto roleDto) {
        RoleDto savedRoleDto = roleClient.saveRole(roleDto);
        return new ResponseEntity<>(savedRoleDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDto> updateRole(@PathVariable("id") Long id, @RequestBody RoleDto roleDto) {
        RoleDto updatedRoleDto = roleClient.putRole(id, roleDto);
        return new ResponseEntity<>(updatedRoleDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) throws NotFoundException {
        roleClient.deleteRole(id);
    }
}
