package it.course.course_spring.business.impl;

import it.course.course_spring.business.RoleBO;
import it.course.course_spring.model.ERole;
import it.course.course_spring.model.Role;
import it.course.course_spring.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleBoImpl implements RoleBO {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findRoleByID(long id) {
        return roleRepository.getReferenceById(id);
    }

    @Override
    public Role save(Role role) {
        roleRepository.save(role);
        return role;
    }

    @Override
    public Set<Role> findAllRole() {
        return (Set<Role>) roleRepository.findAll();
    }

    @Override
    public void deleteRoleByID(long id) {
        roleRepository.deleteById(id);
    }

}
