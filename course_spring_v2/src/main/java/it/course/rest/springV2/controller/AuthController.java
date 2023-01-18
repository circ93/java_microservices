package it.course.rest.springV2.controller;

import it.course.rest.springV2.business.interfaces.RegisterBO;
import it.course.rest.springV2.business.interfaces.UserBO;
import it.course.rest.springV2.business.interfaces.RoleBO;
import it.course.rest.springV2.payload.request.LoginRequest;
import it.course.rest.springV2.payload.request.SignupRequest;
import it.course.rest.springV2.payload.response.MessageResponse;
import it.course.rest.springV2.payload.response.UserInfoResponse;
import it.course.rest.springV2.security.jwt.JwtUtils;
import it.course.rest.springV2.security.services.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  UserBO userBO;

  @Autowired
  RoleBO roleBO;

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @Autowired
  RegisterBO registerBO;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
        .body(new UserInfoResponse(userDetails.getId(),
                                   userDetails.getUsername(),
                                   userDetails.getEmail(),
                                   roles));
  }
  @PostMapping("/signup/mod")
  public ResponseEntity<?>registerMod(@Valid @RequestBody SignupRequest signUpRequest) {
    String msg = registerBO.createUserModerator(signUpRequest);

    return switch (msg) {
      case "usernameExists" ->
              ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
      case "emailExists" -> ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
      case "create" -> ResponseEntity.ok(new MessageResponse("Moderator registered successfully!"));
      default -> ResponseEntity.badRequest().body(new MessageResponse("Errore: qulacosa è andato storto!"));
    };
  }

  @PostMapping("/signup/admin")
  public ResponseEntity<?>registerAdmin(@Valid @RequestBody SignupRequest signUpRequest){
    String msg = registerBO.createUserAdmin(signUpRequest);

    return switch (msg) {
      case "usernameExists" ->
              ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
      case "emailExists" -> ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
      case "create" -> ResponseEntity.ok(new MessageResponse("Admin registered successfully!"));
      default -> ResponseEntity.badRequest().body(new MessageResponse("Errore: qulacosa è andato storto!"));
    };

  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

    String msg = registerBO.createUser(signUpRequest);

    return switch (msg) {
      case "usernameExists" ->
              ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
      case "emailExists" -> ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
      case "create" -> ResponseEntity.ok(new MessageResponse("User registered successfully!"));
      default -> ResponseEntity.badRequest().body(new MessageResponse("Errore: qulacosa è andato storto!"));
    };
  }

  @PostMapping("/signout")
  public ResponseEntity<?> logoutUser() {
    ResponseCookie cookie = registerBO.logout();

    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
        .body(new MessageResponse("You've been signed out!"));
  }
}
