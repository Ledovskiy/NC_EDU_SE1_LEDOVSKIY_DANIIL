package backend.service;

import backend.entity.Role;
import backend.exeption.NotFoundException;
import backend.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefaultRoleService implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public DefaultRoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRole(Long id) throws NotFoundException {
        Optional<Role> Role = roleRepository.findById(id);
        if (Role.isPresent()) {
            return Role.get();
        } else {
            throw new NotFoundException("Role with id: " + id + " was not found");
        }
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Long id, Role role) throws NotFoundException {
        Optional<Role> roleToUpdateOptional = roleRepository.findById(id);
        if (roleToUpdateOptional.isPresent()) {
            Role roleToUpdate = this.updateRoleFields(roleToUpdateOptional.get(), role);
            return roleRepository.save(roleToUpdate);
        } else {
            throw new NotFoundException("Role with id: " + id + " was not found");
        }
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void deleteRoles() {
        roleRepository.deleteAll();
    }

    private Role updateRoleFields(Role RoleToUpdate, Role newRole) {
        if (newRole.getRoleName() != null) {
            RoleToUpdate.setRoleName(newRole.getRoleName());
        }

        return RoleToUpdate;
    }
}

