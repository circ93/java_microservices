package it.course.rest.springV2.business.impl;

import it.course.rest.springV2.business.interfaces.RoleBO;
import it.course.rest.springV2.model.ERole;
import it.course.rest.springV2.model.Role;
import it.course.rest.springV2.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleBOImpl implements RoleBO {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getRole(ERole eRole) {
        switch (eRole) {
            case ROLE_ADMIN:
                return roleRepository.findByName(ERole.ROLE_ADMIN)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            case ROLE_MODERATOR:
                return roleRepository.findByName(ERole.ROLE_MODERATOR)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            default:
                return roleRepository.findByName(ERole.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        }
    }

    @Override
    public Optional<Role> findRoleByName(ERole roleUser) {
        return roleRepository.findByName(roleUser);
    }

}
