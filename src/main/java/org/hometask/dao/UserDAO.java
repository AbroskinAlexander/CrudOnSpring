package org.hometask.dao;

import org.hometask.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(User user);

    User getUserById(Long id);

    public void updateUser(User updateUser);
}
