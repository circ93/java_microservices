package it.course.course_spring.business;

import it.course.course_spring.payload.request.LoginRequest;
import it.course.course_spring.payload.request.SignupRequest;
import it.course.course_spring.security.services.UserDetailsImpl;
import org.springframework.http.ResponseCookie;

public interface RegisterBO {

    public String createUserBusiness(SignupRequest signUpRequest);

    public UserDetailsImpl authUser(LoginRequest loginRequest);

    public ResponseCookie logoutUser();


}
