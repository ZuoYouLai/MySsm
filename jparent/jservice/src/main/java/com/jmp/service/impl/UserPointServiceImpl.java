package com.jmp.service.impl;

import com.jmp.service.UserPointService;
import com.jmp.sql.domain.UserPoint;
import com.jmp.sql.mapper.UserPointMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-09-19 15:50
 * @ Description：
 */
@Service
@Slf4j
public class UserPointServiceImpl implements UserPointService {


    @Autowired
    private UserPointMapper userPointMapper;
    
    @Override
    public void testInsert() {
        UserPoint userPoint = new UserPoint();
        userPoint.setPoint(10);
        userPoint.setPointGroup("IKIK");
        userPoint.setPonitLevel("info");
        userPointMapper.insertSelective(userPoint);
    }


    @Override
    public UserPoint incrPoint(Long id, Integer point) {
        UserPoint userPoint = userPointMapper.selectByPrimaryKey(id);
        userPoint.setPoint(userPoint.getPoint() + point);
        userPointMapper.updateByPrimaryKey(userPoint);
        return userPoint;
    }



    @Override
    public UserPoint decrPoint(Long id, Integer point) {
        UserPoint userPoint = userPointMapper.selectByPrimaryKey(id);
        userPoint.setPoint(userPoint.getPoint() - point);
        userPointMapper.updateByPrimaryKey(userPoint);
        return userPoint;
    }

    @Override
    public void testInsert(String name) {
        UserPoint userPoint = new UserPoint();
        userPoint.setPoint(10);
        userPoint.setPointGroup(name);
        userPoint.setPonitLevel(name);
        userPointMapper.insertSelective(userPoint);
    }

}
