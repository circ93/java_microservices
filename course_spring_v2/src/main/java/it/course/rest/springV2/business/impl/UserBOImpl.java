package it.course.rest.springV2.business.impl;

import it.course.rest.springV2.business.interfaces.UserBO;
import it.course.rest.springV2.model.Role;
import it.course.rest.springV2.model.User;
import it.course.rest.springV2.payload.request.SignupRequest;
import it.course.rest.springV2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserBOImpl implements UserBO {
    @Autowired
    UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User addUserWithRole(User user, Role role){
        Set <Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        return  userRepository.save(user);
    }

    @Override
    public boolean existUser(SignupRequest signUpRequest){
        return userRepository.existsByUsername(signUpRequest.getUsername());
    }
    @Override
    public boolean existEmail(SignupRequest signUpRequest){
        return userRepository.existsByUsername(signUpRequest.getUsername());
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
