package com.jmp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmp.sql.domain.User;
import com.jmp.service.UserService;
import com.jmp.sql.domain.UserExample;
import com.jmp.sql.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

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
        Page page=PageHelper.startPage(1,2);
        List<User> list = userMapper.selectByExample(new UserExample());
        PageInfo pageInfo = page.toPageInfo();
        LOG.info("test service Imp.....");
        LOG.info("total : {}", pageInfo.getPages());
        LOG.info("page size : {}",pageInfo.getPageNum());
        return list;
    }

}
