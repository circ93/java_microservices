package it.course.rest.springV2.business.interfaces;

import it.course.rest.springV2.payload.request.SignupRequest;
import org.springframework.http.ResponseCookie;

public interface RegisterBO {

    public String createUser(SignupRequest signupRequest);

    public String createUserAdmin(SignupRequest signupRequest);

    public String createUserModerator(SignupRequest signupRequest);

    public ResponseCookie logout();

}
