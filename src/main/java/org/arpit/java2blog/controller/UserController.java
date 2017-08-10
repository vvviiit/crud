package org.arpit.java2blog.controller;

import org.arpit.java2blog.model.User;
import org.arpit.java2blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getUsers(Model model) {

        List listOfUsers = userService.getAllUsers();
        model.addAttribute("user", new User());
        model.addAttribute("listOfUsers", listOfUsers);
        return "userDetails";
    }

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public User getUserById(@PathVariable int id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
    public String addUser(@ModelAttribute("user") User user) {

        if (user.getId() == 0) {
            userService.addUser(user);
        } else {
            userService.updateUser(user);
        }
        return "redirect:/getAllUsers";
    }

    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String updateUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.getUser(id));
        model.addAttribute("listOfUsers", this.userService.getAllUsers());
        return "userDetails";
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/getAllUsers";
    }
}
