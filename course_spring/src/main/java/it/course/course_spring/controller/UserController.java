package it.course.course_spring.controller;

import it.course.course_spring.model.User;
import it.course.course_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

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

}
