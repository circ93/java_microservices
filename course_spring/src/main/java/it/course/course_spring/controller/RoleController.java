package it.course.course_spring.controller;

import it.course.course_spring.business.RoleBO;
import it.course.course_spring.model.Role;
import it.course.course_spring.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/")
public class RoleController {

    @Autowired
    RoleBO roleBO;

    @PostMapping("/role")
    public ResponseEntity<Role> createRole(@RequestBody Role roleRequest){
        Role _role = roleBO.save(roleRequest);
        return new ResponseEntity<>(_role, HttpStatus.CREATED);
    }

    @GetMapping("/roles")
    public ResponseEntity<Set<Role>> getRole(){
        Set<Role> roles = new HashSet<>();
        //roleRepository.findAll().forEach(roles::add);
        roles = roleBO.findAllRole();

        if (roles.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(roles, HttpStatus.OK);
        }
    }

    @PutMapping("/role/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable("id") long id, @RequestBody Role roleRequest){
        //Role _role = roleRepository.findById(id).orElse(null);
        Role _role = roleBO.findRoleByID(id);

        if (_role == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            _role.setName(roleRequest.getName());

            Role result = roleBO.save(_role);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }

    }

    @DeleteMapping("role/delete/{id}")
    public ResponseEntity<HttpStatus> deleteRole(@PathVariable("id") long id){
        roleBO.deleteRoleByID(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
