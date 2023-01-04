package it.course.course_spring.controller;

import it.course.course_spring.model.Course;
import it.course.course_spring.model.Role;
import it.course.course_spring.model.User;
import it.course.course_spring.repository.CourseRepository;
import it.course.course_spring.repository.RoleRepository;
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
    @Autowired
    RoleRepository roleRepository;

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

    //assegna un corso ad un utente, entrambi esistenti
    @PostMapping("insertCourse/{idUser}/existcours")
    public ResponseEntity<Course> insertCourse(@PathVariable("idUser") long idUser, @RequestBody Course courseRequest){

        User _user = userRepository.getReferenceById(idUser);
        Course _course = courseRepository.getReferenceById(courseRequest.getId());

        Set<User> userSet = new HashSet<>();
        userSet.add(_user);
        _course.setUsers(userSet);
        Course user_course = courseRepository.save(_course);

        return new ResponseEntity<>(user_course,HttpStatus.NOT_FOUND);

    }

    //inserisce un nuovo corso ad un utente gia esistente
    @PostMapping("insertCourse/{idUser}/course")
    public ResponseEntity<User> createCourseUser(@PathVariable("idUser") long idUser, @RequestBody Course courseRequest){
        User _user = userRepository.getReferenceById(idUser);
        Set<User> userSet = new HashSet<>();
        userSet.add(_user);
        courseRequest.setUsers(userSet);
        courseRepository.save(courseRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //stampa i corsi dell'utente con id passato
    @GetMapping("insertCourse/{id}/courses")
    public Set<Course> getCoursesUser(@PathVariable("id") long id){
        User _user = userRepository.getReferenceById(id);

        return _user.getCourses();
    }

    //assegna un ruolo ad un utente
    @PostMapping("role/assign/{id}")
    public ResponseEntity<User> assignRole(@PathVariable("id") long id, @RequestBody Role roleRequest){

        User _user = userRepository.getReferenceById(id);
        Role _role = roleRepository.getReferenceById(roleRequest.getId());

        if (_user == null || _role == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Set<Role> roleUser = new HashSet<>();

            roleUser.add(_role);
            _user.setRoles(roleUser);
            User newUser = userRepository.save(_user);

            return new ResponseEntity<>(newUser, HttpStatus.OK);
        }
    }

    //restituisce i ruoli dell'utente con id passato
    @GetMapping("role/user/{id}")
    public Set<Role> getRoleUser(@PathVariable("id") long id) {

        User _user = userRepository.getReferenceById(id);

        return _user.getRoles();
    }

    //restituisce tutti gli utenti con ruolo uguale all'id passato
    @GetMapping("role/{id}")
    public Set<User> getUserRole(@PathVariable("id") long id) {

        Role _role = roleRepository.getReferenceById(id);

        return _role.getUsers();
    }









}
