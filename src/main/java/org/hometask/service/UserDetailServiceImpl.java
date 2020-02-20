package org.hometask.service;

import org.hometask.dao.UserDAO;
import org.hometask.model.User;
import org.hometask.model.UserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

    private UserDAO userDAO;

    @Autowired
    public UserDetailServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userDAO.getUserByName(s);
        if(user.isPresent()){
            return new UserDetailImpl(user.get());
        }else throw new IllegalArgumentException("User not found");
    }
}
