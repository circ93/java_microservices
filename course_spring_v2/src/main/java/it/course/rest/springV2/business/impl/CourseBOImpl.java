package it.course.rest.springV2.business.impl;

import it.course.rest.springV2.business.interfaces.CourseBO;
import it.course.rest.springV2.exception.ResourceNotFoundException;
import it.course.rest.springV2.model.Course;
import it.course.rest.springV2.model.User;
import it.course.rest.springV2.repository.CourseRepository;
import it.course.rest.springV2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


@Service
public class CourseBOImpl implements CourseBO {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public Course findByIdFile(Long id) {
        return courseRepository.findById(id).get();
    }


   @Override
    public void uploadFile(Long id, MultipartFile data) throws IOException {
        Course _course = courseRepository.getReferenceById(id);
        _course.setData(data.getBytes());
        _course.setType(data.getContentType());
        courseRepository.save(_course);
    }

    public Course createCourseUser(Long id , Course course){
        User user = userRepository.getReferenceById(id);
        Set<User> userSet = new HashSet<>();
        userSet.add(user);
        course.setUsers(userSet);
        Course _course = courseRepository.save(course);
        return _course;
    }

    public Course findCourse (Long id){
        Course _course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Corso non trovato sotto questo id = " + id));
        return _course;
    }

    public void deleteById(Long id ){
        courseRepository.deleteById(id);
    }

    public ArrayList<Course> findAll(){
        return (ArrayList<Course>) courseRepository.findAll();
    }

    public void save(Course course){
        Course _course = courseRepository.save(course);
    }


}
