package it.course.course_spring.controller;

import it.course.course_spring.model.Course;
import it.course.course_spring.model.User;
import it.course.course_spring.repository.CourseRepository;
import it.course.course_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CourseRepository courseRepository;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User _user = userRepository.save(user);
        return new ResponseEntity<>(_user, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<Set<User>> getUsers(){
        Set<User> setUsers = new LinkedHashSet<>();
        userRepository.findAll().forEach(setUsers::add);
        if (setUsers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(setUsers, HttpStatus.OK);

    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User userRequest){
        User _user = userRepository.getReferenceById(id);

        if (_user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            _user.setUsername(userRequest.getUsername());
            _user.setEmail(userRequest.getEmail());
            _user.setPassword(userRequest.getPassword());
            _user.setCourses(userRequest.getCourses());

            User result = userRepository.save(_user);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }

    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id){
        userRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("insertCourse/{idUser}/{idCourse}")
    public ResponseEntity<User> insertCourse(@PathVariable("idUser") long idUser, @PathVariable("idCourse") long idCourse){

        User _user = userRepository.getReferenceById(idUser);
        Course _course = courseRepository.getReferenceById(idCourse);

        if (_user != null && _course != null){
            _user.addCourse(_course);
            _course.addUser(_user);

            return new ResponseEntity<>(_user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("insertCourse/{idUser}/course")
    public ResponseEntity<User> insertCourse(@PathVariable("idUser") long idUser, @RequestBody Course courseRequest){
        User _user = userRepository.getReferenceById(idUser);
        Set<User> userSet = new HashSet<>();
        userSet.add(_user);
        courseRequest.setUsers(userSet);
        Course _course = courseRepository.save(courseRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
