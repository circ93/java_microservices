package it.course.rest.springV2.business.impl;

import it.course.rest.springV2.business.interfaces.RegisterBO;
import it.course.rest.springV2.business.interfaces.UserBO;
import it.course.rest.springV2.model.ERole;
import it.course.rest.springV2.model.Role;
import it.course.rest.springV2.model.User;
import it.course.rest.springV2.payload.request.SignupRequest;
import it.course.rest.springV2.repository.RoleRepository;
import it.course.rest.springV2.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterBoImpl implements RegisterBO {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserBO userBO;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public String checkUserAndEmail(SignupRequest signupRequest) {
        String msg;
        if (userBO.existsByUsername(signupRequest.getUsername())) {
            msg = "usernameExists";
            return msg;
        }
        if (userBO.existsByEmail(signupRequest.getEmail())) {
            msg = "emailExists";
            return msg;
        }

        return "OK";
    }

    @Override
    public String createUser(SignupRequest signupRequest) {

        String msg = checkUserAndEmail(signupRequest);

        if (msg.equals("OK")) {
            User user = new User(signupRequest.getUsername(),
                    signupRequest.getEmail(),
                    encoder.encode(signupRequest.getPassword()));
            Role modRole = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            userBO.addUserWithRole(user,modRole);
            return "create";
        }

        return msg;
    }

    @Override
    public String createUserAdmin(SignupRequest signupRequest) {

        String msg = checkUserAndEmail(signupRequest);

        if (msg.equals("OK")){
            User user = new User(signupRequest.getUsername(),
                    signupRequest.getEmail(),
                    encoder.encode(signupRequest.getPassword()));
            Role modRole = roleRepository.findByName(ERole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            userBO.addUserWithRole(user,modRole);
            return "create";
        }

        return msg;
    }

    @Override
    public String createUserModerator(SignupRequest signupRequest) {

        String msg = checkUserAndEmail(signupRequest);

        if (msg.equals("OK")){
            User user = new User(signupRequest.getUsername(),
                    signupRequest.getEmail(),
                    encoder.encode(signupRequest.getPassword()));
            Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            userBO.addUserWithRole(user,modRole);
            return "create";
        }

        return msg;
    }

    @Override
    public ResponseCookie logout() {
        return jwtUtils.getCleanJwtCookie();
    }
}
