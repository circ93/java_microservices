package it.course.rest.springV2.repository;

import it.course.rest.springV2.model.ERole;
import it.course.rest.springV2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}