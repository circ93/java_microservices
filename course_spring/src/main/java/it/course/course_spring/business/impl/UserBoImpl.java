package it.course.course_spring.business.impl;

import it.course.course_spring.business.UserBO;
import it.course.course_spring.model.User;
import it.course.course_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserBoImpl implements UserBO {

    @Autowired
    UserRepository userRepository;

    @Override
    public Set<User> findAllUsers() {

        return (Set<User>) userRepository.findAll();
    }

    @Override
    public User findUserById(long id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteByID(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Boolean existUserByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
