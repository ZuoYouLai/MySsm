package com.jmp.sql.mapper;

import com.jmp.sql.domain.Passports;
import com.jmp.sql.domain.PassportsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PassportsMapper {
    int countByExample(PassportsExample example);

    int deleteByExample(PassportsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Passports record);

    int insertSelective(Passports record);

    List<Passports> selectByExample(PassportsExample example);

    Passports selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Passports record, @Param("example") PassportsExample example);

    int updateByExample(@Param("record") Passports record, @Param("example") PassportsExample example);

    int updateByPrimaryKeySelective(Passports record);

    int updateByPrimaryKey(Passports record);
}