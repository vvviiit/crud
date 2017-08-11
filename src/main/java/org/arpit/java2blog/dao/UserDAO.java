package org.arpit.java2blog.dao;

import org.arpit.java2blog.model.User;

import java.util.List;

public interface UserDAO {
    public List getAllUsers();

    public User getUser(int id);

    public User addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);
}
