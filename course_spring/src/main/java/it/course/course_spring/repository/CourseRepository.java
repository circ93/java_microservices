package it.course.course_spring.repository;

import it.course.course_spring.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Course getReferenceById(long id);

}
