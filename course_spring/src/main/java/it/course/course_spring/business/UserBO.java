package it.course.course_spring.business;


import it.course.course_spring.model.User;

import java.util.Set;

public interface UserBO {

    public Set<User> findAllUsers();

    public User findUserById(long id);

    public User save(User user);

    public void deleteByID(long id);

    public Boolean existUserByUsername(String username);

    public Boolean existsUserByEmail(String email);

}
