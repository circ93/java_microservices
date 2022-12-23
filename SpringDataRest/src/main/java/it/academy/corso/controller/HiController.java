package it.academy.corso.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HiController {

    @GetMapping("/hola")
    public ResponseEntity<String> hola (){
        String message = "Hola Gianluca";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/hola2")
    public ResponseEntity<Map<String,String>> hi2 (){
        Map <String,String> value = new HashMap<>();
        value.put("Message","Bella zi");
        value.put("Destination","Babbonatale");
        return new ResponseEntity<>(value, HttpStatus.OK);
    }

}
