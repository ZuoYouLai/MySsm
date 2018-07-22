package com.jmp.service;

import com.jmp.sql.domain.User;

import java.util.List;

public interface UserService {

    int createOneUser();

    List<User> getUserList();

}
