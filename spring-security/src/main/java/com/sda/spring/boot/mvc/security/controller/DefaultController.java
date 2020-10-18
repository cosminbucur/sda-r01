package com.sda.spring.boot.mvc.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// create controller with multiple endpoints
@Controller
public class DefaultController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
//    @RequestMapping("/restricted")
//    public String restricted() {
//        return "You found the secret page!";
//    }

}
