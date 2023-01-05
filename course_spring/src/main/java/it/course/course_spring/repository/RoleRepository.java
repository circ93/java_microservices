package it.course.course_spring.repository;

import it.course.course_spring.model.ERole;
import it.course.course_spring.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}
