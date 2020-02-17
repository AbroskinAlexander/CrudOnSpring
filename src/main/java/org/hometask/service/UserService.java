package org.hometask.service;

import org.hometask.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    boolean addUser(User user);

    void deleteUser(User user);

    User getUserById(Long id);

    public void updateUser(User updateUser);
}
