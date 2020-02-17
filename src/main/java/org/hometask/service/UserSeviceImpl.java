package org.hometask.service;

import org.hometask.dao.UserDAO;
import org.hometask.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserSeviceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public boolean addUser(User user) {
        if (userDAO.getAllUsers().contains(user)) {
            return false;
        } else {
            userDAO.addUser(user);
            return true;
        }
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public void updateUser(User updateUser) {
        userDAO.updateUser(updateUser);
    }
}
