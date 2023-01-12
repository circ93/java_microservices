package it.course.course_spring.controller;

import it.course.course_spring.business.CourseBO;
import it.course.course_spring.model.Course;
import it.course.course_spring.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    CourseBO courseBO;

    @PostMapping("/course")
    public ResponseEntity<Course> createCourses (@RequestBody Course course){
        Course _course = courseBO.save(course);
        return new ResponseEntity<>(_course, HttpStatus.CREATED);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses (){
        List<Course> courseArrayList = new ArrayList<Course>();
        //courseRepository.findAll().forEach(courseArrayList::add);
        courseArrayList = courseBO.findAllCourse();
        if (courseArrayList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(courseArrayList, HttpStatus.OK);
    }

    @DeleteMapping("course/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") long id) {
        //courseRepository.deleteById(id);
        courseBO.deleteByID(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("course/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") long id, @RequestBody Course courseRequest) {
        //siccome potrei ricevere un oggetto course null va gestito l'errore,
        //o in questo modo implementando il metodo getReferenceById nell'interfaccia CourseRepo
        //oppure creando una execption custom
        Course _course = courseBO.findCourseByID(id);

        if (_course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            _course.setDescription(courseRequest.getDescription());
            _course.setName(courseRequest.getName());

            Course result = courseBO.save(_course);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }

    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourseById (@PathVariable("id") long id){
        Course _course = courseBO.findCourseByID(id);
        if (_course == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(_course, HttpStatus.OK);
        }

    }

}
