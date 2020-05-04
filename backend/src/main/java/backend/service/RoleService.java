package backend.service;

import backend.entity.Role;
import backend.exeption.NotFoundException;

import java.util.List;

public interface RoleService {

    Role getRole(Long id) throws NotFoundException;

    Role saveRole(Role role);

    Role updateRole(Long id, Role role) throws NotFoundException;

    void deleteRole(Long id);

    List<Role> getRoles();

    void deleteRoles();
}
