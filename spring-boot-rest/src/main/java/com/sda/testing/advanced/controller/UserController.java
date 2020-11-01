package com.sda.testing.advanced.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserController {

    @PostMapping("/auth")
    public ResponseEntity<String> authenticate() {
        return ResponseEntity.ok("authenticated");
    }
}
