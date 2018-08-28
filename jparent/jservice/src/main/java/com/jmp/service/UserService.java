package com.jmp.service;

import com.jmp.sql.domain.User;
import com.jmp.sql.domain.UserExample;

import java.util.List;

public interface UserService {

    int createOneUser();

    List<User> getUserList();

    User getOneUser(UserExample example);

}
