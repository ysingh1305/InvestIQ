package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService{
    
    private UserRepository repository;

    public LoginServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean doLogin(User user) {
        return repository.isValidUser(user.getUserName(), user.getPassword());
    }
}
