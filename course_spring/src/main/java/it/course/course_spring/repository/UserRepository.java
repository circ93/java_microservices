package it.course.course_spring.repository;

import it.course.course_spring.model.Course;
import it.course.course_spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getReferenceById(long id);

}
