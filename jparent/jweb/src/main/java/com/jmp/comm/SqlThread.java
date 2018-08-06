package com.jmp.comm;

import com.jmp.service.UserService;
import com.jmp.sql.domain.User;
import com.jmp.sql.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SqlThread implements  Runnable{

    private Integer index;
    private Integer end;

    public SqlThread() {
    }

    public SqlThread(Integer index, Integer end) {
        this.index = index;
        this.end = end;
    }

    @Override
    public void run() {
        log.info("index : {}",index);
        UserMapper userService = ApplicationContextHelper.popBean(UserMapper.class);
        User user = new User();
        user.setName(index + "");
        user.setPassword(end + "");
        userService.insert(user);
        log.info("end : {}",index);
    }
}
