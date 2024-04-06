package com.example.demo.service;

import com.example.demo.model.User;

public interface LoginService {
    default boolean doLogin(User user) {
        return false;
    };

    default boolean doLogout(User user) {
        return true;
    }
}
