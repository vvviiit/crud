package org.arpit.java2blog.dao;

import org.arpit.java2blog.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public List getAllUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List userList = session.createQuery("from User").list();
        return userList;
    }

    public User getUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User country = (User) session.load(User.class, id);
        return country;
    }

    public User addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        return user;
    }

    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    public void deleteUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User p = (User) session.load(User.class, id);
        if (null != p) {
            session.delete(p);
        }
    }

}
