package org.arpit.java2blog.service;

import org.arpit.java2blog.dao.UserDAO;
import org.arpit.java2blog.model.User;
import org.arpit.java2blog.model.UserPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Transactional
    public List getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Transactional
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    @Transactional
    public List<User> getUsers(String name) {
        return userDAO.list(name);
    }

    @Transactional
    public UserPage getUsers(final Integer page) {
        return userDAO.listPage(page);
    }
}
