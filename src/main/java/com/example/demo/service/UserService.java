package com.example.demo.service;

import com.example.demo.domain.User;

public interface UserService {

    int insertUser(User user);

    User get(Integer id);

}
