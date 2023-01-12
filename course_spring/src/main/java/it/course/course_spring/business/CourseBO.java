package it.course.course_spring.business;

import it.course.course_spring.model.Course;

import java.util.List;
import java.util.Set;

public interface CourseBO {

    public Course save(Course course);

    public void deleteByID(long id);

    public Course findCourseByID(long id);

    public List<Course> findAllCourse();

}
