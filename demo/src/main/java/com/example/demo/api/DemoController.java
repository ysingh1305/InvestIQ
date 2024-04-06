package com.example.demo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class DemoController {

    private LoginService loginService;

    public DemoController(LoginService loginService) {
        this.loginService = loginService;
    }
    
    @PostMapping("/login")    
    public ResponseEntity<String> doLogin(@RequestBody User user) {
        log.info("Login details: {}", user.toString());
        if (loginService.doLogin(user)) {
            return ResponseEntity.ok().body("Success");
        }
        return ResponseEntity.badRequest().body("Invalid credentials");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> doLogout(User user) {
        if (loginService.doLogout(user)) {
            return ResponseEntity.ok().body("Success");
        }
        return ResponseEntity.badRequest().body("Invalid User");
    
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        return ResponseEntity.ok().body("Success");
    }
}