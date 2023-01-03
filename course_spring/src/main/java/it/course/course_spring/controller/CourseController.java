package it.course.course_spring.controller;

import it.course.course_spring.model.Course;
import it.course.course_spring.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @PostMapping("/course")
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        Course _course = courseRepository.save(course);
        return new ResponseEntity<>(_course, HttpStatus.CREATED);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourse (){
        List<Course> courseArrayList = new ArrayList<Course>();
        courseRepository.findAll().forEach(courseArrayList::add);
        if (courseArrayList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(courseArrayList, HttpStatus.OK);
    }

    @DeleteMapping("course/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") long id) {
        courseRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("course/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") long id, @RequestBody Course courseRequest) {
        Course _course = courseRepository.getReferenceById(id);

        if (_course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            _course.setDescription(courseRequest.getDescription());
            _course.setName(courseRequest.getName());

            Course result = courseRepository.save(_course);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }

    }

}
