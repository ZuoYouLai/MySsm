package com.jmp.sql.mapper;

import com.jmp.sql.domain.UserPoint;
import com.jmp.sql.domain.UserPointExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPointMapper {
    int countByExample(UserPointExample example);

    int deleteByExample(UserPointExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserPoint record);

    int insertSelective(UserPoint record);

    List<UserPoint> selectByExample(UserPointExample example);

    UserPoint selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserPoint record, @Param("example") UserPointExample example);

    int updateByExample(@Param("record") UserPoint record, @Param("example") UserPointExample example);

    int updateByPrimaryKeySelective(UserPoint record);

    int updateByPrimaryKey(UserPoint record);
}