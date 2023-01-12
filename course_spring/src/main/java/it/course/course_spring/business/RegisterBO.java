package it.course.course_spring.business;

import it.course.course_spring.model.User;
import it.course.course_spring.payload.request.SignupRequest;

public interface RegisterBO {

    public User createUserBusiness(SignupRequest signUpRequest);

}
