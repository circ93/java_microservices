package it.course.rest.springV2.controller;


import it.course.rest.springV2.business.interfaces.CourseBO;
import it.course.rest.springV2.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    CourseBO courseBo;

    @PostMapping("/course")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        courseBo.save(course);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable("id") Long id) {
        Course _course = courseBo.findCourse(id);
        if (!_course.getId().toString().isEmpty()) {
            return new ResponseEntity<>(_course, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/course")
    public ResponseEntity<ArrayList<Course>> getAllCourse() {
        ArrayList<Course> _course = courseBo.findAll();
        return new ResponseEntity<>(_course, HttpStatus.OK);
    }
    @DeleteMapping("/course/{id}")
    public  ResponseEntity<String> deleteCourse(@PathVariable long id){
        courseBo.deleteById(id);
        return new ResponseEntity<>("Course con id " + id + " eliminato con successo!",HttpStatus.OK);
    }

    @PutMapping("/course/{id}")
    public ResponseEntity<Course> updateRoles(@PathVariable("id") long id, @RequestBody Course course) {
        Course _course = courseBo.findCourse(id);
        _course.setName(course.getName());
        courseBo.save(_course);
        return new ResponseEntity<>(_course, HttpStatus.OK);
    }
    @PostMapping("/user/{id}/course")
    public ResponseEntity<String> createCourseUser(@PathVariable Long id ,@RequestBody Course course) {
       Course _course = courseBo.createCourseUser(id, course);
        return new ResponseEntity<>("Nuovo utente creato con successo!",HttpStatus.CREATED);
    }
    @PostMapping("/upload/{id}")
    public ResponseEntity<Map<String,String>> uploadFile(@PathVariable Long id ,@RequestParam("file") MultipartFile data) {
        try {
            courseBo.uploadFile(id, data);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String,String> map = new HashMap<>();
            String message = "Non posso caricare il file: " + data.getOriginalFilename();
            map.put("Error",message);
            return new ResponseEntity<>(map, HttpStatus.EXPECTATION_FAILED);

        }
    }
    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        Course _course = courseBo.findByIdFile(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + _course.getName() + "\"")
                .body(_course.getData());
    }

    @DeleteMapping("/deletefile/{id}")
    public ResponseEntity<String> deleteFile(@PathVariable Long id) {
        courseBo.deleteFileById(id);

        return new ResponseEntity<>("File con id " + id + " eliminato!", HttpStatus.OK);

    }

}
