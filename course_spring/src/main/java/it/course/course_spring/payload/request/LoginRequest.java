package it.course.course_spring.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


public class LoginRequest {
    @NotBlank
    @Setter
    @Getter
    private String username;

    @NotBlank
    @Getter
    @Setter

    private String password;
}