package backend.web.controller;

import backend.dto.RoleDto;
import backend.entity.Role;
import backend.exeption.NotFoundException;
import backend.mapper.RoleMapper;
import backend.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    private final RoleService roleService;
    private final RoleMapper mapper;

    @Autowired
    public RoleController(RoleService roleService, RoleMapper mapper) {
        this.roleService = roleService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> getRole(@PathVariable("id") Long id) throws NotFoundException {
        Role role = roleService.getRole(id);
        RoleDto roleDto = mapper.toDto(role);
        return new ResponseEntity<>(roleDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<RoleDto>> getRole() {
        List<Role> role = roleService.getRoles();
        List<RoleDto> roleDto = role.stream().map((mapper::toDto)).collect(Collectors.toList());
        return new ResponseEntity<>(roleDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleDto> saveRole(@RequestBody RoleDto roleDto) {
        Role role = mapper.toEntity(roleDto);
        Role savedRole = roleService.saveRole(role);
        RoleDto savedRoleDto = mapper.toDto(savedRole);
        return new ResponseEntity<>(savedRoleDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDto> updateRole(@PathVariable("id") Long id, @RequestBody RoleDto roleDto) {
        Role role = mapper.toEntity(roleDto);
        Role updatedRole = roleService.updateRole(id, role);
        RoleDto updatedRoleDto = mapper.toDto(updatedRole);
        return new ResponseEntity<>(updatedRoleDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoleDto> deleteRole(@PathVariable("id") Long id) throws NotFoundException {
        this.roleService.deleteRole(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<RoleDto> deleteRole() {
        this.roleService.deleteRoles();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
