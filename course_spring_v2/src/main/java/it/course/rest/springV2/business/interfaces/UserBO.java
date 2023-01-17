package it.course.rest.springV2.business.interfaces;

import it.course.rest.springV2.model.Role;
import it.course.rest.springV2.model.User;
import it.course.rest.springV2.payload.request.SignupRequest;

import java.util.Optional;

public interface UserBO {
    public User saveUser(User user);
    public boolean existUser(SignupRequest signUpRequest);
    public boolean existEmail(SignupRequest signUpRequest);
    public User addUserWithRole(User user, Role role);
}
