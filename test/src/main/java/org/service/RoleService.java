package org.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.entity.Role;
import org.repository.RoleRepository;

import java.util.List;

@ApplicationScoped
public class RoleService {
    @Inject
    RoleRepository roleRepository;

    @Transactional
    public List<Role> roleList(){
        return roleRepository.listAll();
    }
    @Transactional
    public Role roleById(long id){
        Role existingRole = roleRepository.findById(id);
        if (existingRole == null){
            throw new WebApplicationException("Role not found", 404);
        }
        return roleRepository.findById(id);
    }

    @Transactional
    public void createRole( Role role){
        roleRepository.persist(role);
    }

    @Transactional
    public void updateRole(long id, Role updateRole){
        Role existingRole = roleRepository.findById(id);
        if (existingRole == null){
            throw new WebApplicationException("Role not found", 404);
        }
        existingRole.setRole(updateRole.getRole());
        roleRepository.persist(existingRole);
    }

    @Transactional
    public void deleteRole(long id){
        Role existingRole = roleRepository.findById(id);
        if (existingRole == null){
            throw new WebApplicationException("Role not found", 404);
        }
        roleRepository.delete(existingRole);
    }
}
