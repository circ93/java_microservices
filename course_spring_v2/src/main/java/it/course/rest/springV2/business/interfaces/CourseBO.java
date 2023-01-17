package it.course.rest.springV2.business.interfaces;

import it.course.rest.springV2.model.Course;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

public interface CourseBO  {
     public Course findByIdFile(Long id);
     public void uploadFile(Long id, MultipartFile data) throws IOException;
     public Course createCourseUser(Long id , Course course);

     public Course findCourse(Long id );
     public void deleteById(Long id );

     public ArrayList<Course> findAll();

     public void save(Course course);
}
