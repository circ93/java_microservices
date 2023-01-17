package it.course.rest.springV2.repository;

import it.course.rest.springV2.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}