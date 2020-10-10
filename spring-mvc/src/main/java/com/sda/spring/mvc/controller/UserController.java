package com.sda.spring.mvc.controller;

import com.sda.spring.mvc.model.User;
import com.sda.spring.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // create user form

    // map path to method
    @RequestMapping(name = "/users", method = RequestMethod.GET)
    public String userForm(Model model) {

        List<User> users = userService.findAll();

        //  whatever will be added to the model, will be available in the view
        model.addAttribute("users", users);

        // this view will be returned by the view resolver
        return "editUsers";
    }
}
