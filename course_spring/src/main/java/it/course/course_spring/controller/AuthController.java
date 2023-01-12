package it.course.course_spring.controller;

import it.course.course_spring.business.impl.Register;
import it.course.course_spring.payload.request.LoginRequest;
import it.course.course_spring.payload.request.SignupRequest;
import it.course.course_spring.payload.response.MessageResponse;
import it.course.course_spring.payload.response.UserInfoResponse;
import it.course.course_spring.security.services.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    Register register;

    //il controllere restituisce solo la risposta, quindi tutta la lalogica di implementazione sta nella business

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        UserDetailsImpl userDetails = register.authUser(loginRequest);

        ResponseCookie jwtCookie = register.authUserCookie(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new UserInfoResponse(userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

        String msg = register.createUserBusiness(signUpRequest);

        return switch (msg) {
            case "usernameExists" ->
                    ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
            case "emailExists" ->
                    ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
            case "Create" -> ResponseEntity.ok(new MessageResponse("User registered successfully!"));
            default -> ResponseEntity.badRequest().body(new MessageResponse("Errore: qulacosa è andato storto!"));
        };
    }

    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = register.logoutUser();

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }
}
