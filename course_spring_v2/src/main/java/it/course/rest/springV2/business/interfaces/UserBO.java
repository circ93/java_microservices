package it.course.rest.springV2.business.interfaces;

import it.course.rest.springV2.model.Role;
import it.course.rest.springV2.model.User;
import it.course.rest.springV2.payload.request.SignupRequest;

public interface UserBO {
    User saveUser(User user);
    boolean existUser(SignupRequest signUpRequest);
    boolean existEmail(SignupRequest signUpRequest);
    User addUserWithRole(User user, Role role);
}
