package it.course.rest.springV2.business.interfaces;

import it.course.rest.springV2.model.ERole;
import it.course.rest.springV2.model.Role;

public interface RoleBO {
    Role getRole(ERole eRole);
}
