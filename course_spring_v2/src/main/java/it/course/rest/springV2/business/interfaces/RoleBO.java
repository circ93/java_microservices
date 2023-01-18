package it.course.rest.springV2.business.interfaces;

import it.course.rest.springV2.model.ERole;
import it.course.rest.springV2.model.Role;

import java.util.Optional;

public interface RoleBO {
    Role getRole(ERole eRole);

    Optional<Role> findRoleByName(ERole roleUser);
}
