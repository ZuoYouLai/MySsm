package com.jmp.service.impl;

import com.github.pagehelper.PageHelper;
import com.jmp.sql.domain.User;
import com.jmp.service.UserService;
import com.jmp.sql.domain.UserExample;
import com.jmp.sql.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public int createOneUser() {
        User user = new User();
        user.setName("Mr.LaiHaoDa");
        user.setPassword("123");
        return userMapper.insert(user);
    }

    @Override
    public List<User> getUserList() {
        PageHelper.startPage(1,2);
        List<User> list = userMapper.selectByExample(new UserExample());
        return list;
    }

}
