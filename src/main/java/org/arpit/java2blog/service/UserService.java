package org.arpit.java2blog.service;

import org.arpit.java2blog.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public List getAllUsers();


    public User getUser(int id);


    public void addUser(User user);


    public void updateUser(User user);


    public void deleteUser(int id);
}
