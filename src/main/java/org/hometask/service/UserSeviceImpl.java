package org.hometask.service;

import org.hometask.dao.UserDAO;
import org.hometask.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserSeviceImpl implements UserService {

    private UserDAO userDAO;

    public UserSeviceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public boolean addUser(User user) {
        if(userDAO.ExistUser(user)){
            userDAO.addUser(user);
            return true;
        }
        return false;
    }

    @Override
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void updateUser(User updateUser) {
        userDAO.updateUser(updateUser);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }
}
