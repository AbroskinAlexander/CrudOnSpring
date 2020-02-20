package org.hometask.dao;

import org.hometask.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(User user);

    User getUserById(Long id);

    void updateUser(User updateUser);

    boolean ExistUser(User user);

    User getUserByEmail(String email);

    Optional<User> getUserByName(String name);
}
