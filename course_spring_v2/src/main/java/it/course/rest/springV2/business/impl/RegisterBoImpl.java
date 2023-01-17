package it.course.rest.springV2.business.impl;

import it.course.rest.springV2.business.interfaces.RegisterBO;
import it.course.rest.springV2.business.interfaces.UserBO;
import it.course.rest.springV2.model.ERole;
import it.course.rest.springV2.model.Role;
import it.course.rest.springV2.model.User;
import it.course.rest.springV2.payload.request.SignupRequest;
import it.course.rest.springV2.repository.RoleRepository;
import it.course.rest.springV2.repository.UserRepository;
import it.course.rest.springV2.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegisterBoImpl implements RegisterBO {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserBO userBO;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public String createUser(SignupRequest signupRequest) {

        String msg;
        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            msg = "usernameExists";
            return msg;
        }
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            msg = "emailExists";
            return msg;
        }
        User user = new User(signupRequest.getUsername(),
                signupRequest.getEmail(),
                encoder.encode(signupRequest.getPassword()));
        Role modRole = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        userBO.addUserWithRole(user,modRole);
        msg = "create";

        return msg;

    }

    @Override
    public String createUserAdmin(SignupRequest signupRequest) {

        String msg;
        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            msg = "usernameExists";
            return msg;
        }
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            msg = "emailExists";
            return msg;
        }
        User user = new User(signupRequest.getUsername(),
                signupRequest.getEmail(),
                encoder.encode(signupRequest.getPassword()));
        Role modRole = roleRepository.findByName(ERole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        userBO.addUserWithRole(user,modRole);
        msg = "create";

        return msg;

    }

    @Override
    public String createUserModerator(SignupRequest signupRequest) {

        String msg;
        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            msg = "usernameExists";
            return msg;
        }
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            msg = "emailExists";
            return msg;
        }
        User user = new User(signupRequest.getUsername(),
                signupRequest.getEmail(),
                encoder.encode(signupRequest.getPassword()));
        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        userBO.addUserWithRole(user,modRole);
        msg = "create";

        return msg;

    }

    @Override
    public ResponseCookie logout() {
        return jwtUtils.getCleanJwtCookie();
    }
}
