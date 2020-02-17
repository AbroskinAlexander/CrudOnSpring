package org.hometask.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hometask.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("From User",User.class).list();
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void deleteUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    @Override
    public User getUserById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class,id);
    }

    public void updateUser(User updateUser) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(updateUser);
    }
}
