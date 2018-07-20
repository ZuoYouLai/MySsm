package com.jmp.service.impl;

import com.jmp.service.UserService;
import com.jmp.sql.domain.User;
import com.jmp.sql.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int createOneUser() {
        User user = new User();
        user.setName("Mr.LaiHaoDa");
        user.setPassword("123");
        return userMapper.insert(user);
    }

}
