package it.course.course_spring.business.impl;

import it.course.course_spring.business.CourseBO;
import it.course.course_spring.model.Course;
import it.course.course_spring.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CourseBoImpl implements CourseBO {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        courseRepository.save(course);
        return course;
    }

    @Override
    public void deleteByID(long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course findCourseByID(long id) {
        Course _course = courseRepository.getReferenceById(id);
        return _course;
    }

    @Override
    public List<Course> findAllCourse() {
        return (List<Course>) courseRepository.findAll();
    }
}
