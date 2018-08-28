package com.jmp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.jmp.sql.domain.User;
import com.jmp.service.UserService;
import com.jmp.sql.domain.UserExample;
import com.jmp.sql.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
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
        Page page=PageHelper.startPage(1,2);
        List<User> list = userMapper.selectByExample(new UserExample());
        PageInfo pageInfo = page.toPageInfo();
        log.info("test service Imp.....");
        log.info("total : {}", pageInfo.getPages());
        log.info("page size : {}",pageInfo.getPageNum());
        return list;
    }



    @Override
    public User getOneUser(UserExample example) {
        List<User> userList = userMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(userList)) {
            return userList.get(0);
        }
        return null;
    }

}
