package com.sda.spring.boot.mvc.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class PublicRestApiController {

    @GetMapping("mobile")
    public String mobileEndPoint() {
        return "API mobile content";
    }

    @GetMapping("webapp")
    public String webAppEndPoint() {
        return "API web app content";
    }
}
