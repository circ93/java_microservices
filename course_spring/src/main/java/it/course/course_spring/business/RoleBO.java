package it.course.course_spring.business;

import it.course.course_spring.model.ERole;
import it.course.course_spring.model.Role;

import java.util.Set;

public interface RoleBO {

    public Role findRoleByID(long id);

    public Role save(Role role);

    public Set<Role> findAllRole();

    public void deleteRoleByID(long id);



}
