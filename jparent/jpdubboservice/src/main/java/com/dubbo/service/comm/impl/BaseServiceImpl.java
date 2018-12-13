package com.dubbo.service.comm.impl;

import com.alibaba.fastjson.JSONObject;
import com.japi.service.BaseService;
import com.jmp.sql.domain.User;
import com.jmp.sql.domain.UserPoint;
import com.jmp.sql.domain.UserPointExample;
import com.jmp.sql.mapper.UserMapper;
import com.jmp.sql.mapper.UserPointMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-12-13 16:06
 * @ Description：dubbo服务的内容
 */
@Slf4j
@Service
public class BaseServiceImpl implements BaseService{

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserPointMapper userPointMapper;


    @Transactional
    @Override
    public JSONObject doOneUserGroup(Long userId) {
        JSONObject jsonObject = new JSONObject();
        User user = userMapper.selectByPrimaryKey(userId);
        Assert.notNull(user, "用户的名称不能为空...");
        user.setUpdatedAt(new Date());
        //更新用户的操作
        userMapper.updateByPrimaryKey(user);
        jsonObject.put("user", user);
        UserPointExample userPointExample = new UserPointExample();
        userPointExample.createCriteria().andUserIdEqualTo(userId);
        List<UserPoint> userPointList = userPointMapper.selectByExample(userPointExample);
        if (!CollectionUtils.isEmpty(userPointList)) {
            UserPoint userPoint = userPointList.get(0);
            Integer targetPoint = userPoint.getPoint();
            userPoint.setPoint(targetPoint + 5);
            userPoint.setUpdatedAt(new Date());
            userPointMapper.updateByPrimaryKey(userPoint);
            jsonObject.put("point", userPoint);
        }
        return jsonObject;
    }
}
