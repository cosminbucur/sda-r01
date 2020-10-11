package com.sda.spring.mvc.controller;

import com.sda.spring.mvc.model.User;
import com.sda.spring.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // map path to method
    @GetMapping
    public String users(Model model) {

        List<User> users = userService.findAll();

        //  whatever will be added to the model, will be available in the view
        model.addAttribute("users", users);

        // this view will be returned by the view resolver
        return "index";
    }
}
