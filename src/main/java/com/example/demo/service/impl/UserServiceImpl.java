package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public int insertUser(User user) {
        user.setName("zxy");
        user.setAge(24);
        user.setNum(123);
        user.setCreateDate(new Date());
        return userMapper.insertUser(user);
    }


    @Override
    public User get(Integer id) {
        return userMapper.get(id);
    }
}
