package com.service;

import com.google.common.base.Function;
import com.jmp.comm.Utils.AESUtil;
import com.jmp.comm.Utils.ToolUtils;
import com.jmp.service.UserPointService;
import com.jmp.sql.domain.Passports;
import com.jmp.sql.domain.UserPoint;
import com.jmp.sql.domain.UserPointExample;
import com.jmp.sql.mapper.PassportsMapper;
import com.jmp.sql.mapper.UserPointMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import weixin.popular.util.EmojiUtil;

import java.util.Date;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-09-19 15:55
 * @ Description：
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class UserPointServiceTest {

    @Autowired
    private UserPointService userPointService;
    @Autowired
    private UserPointMapper userPointMapper;

    @Autowired
    private PassportsMapper passportsMapper;




     /**
        *
        */
      @Test
      public void test0021(){
          Passports passports = new Passports();
          passports.setAccount("lhd");
          passports.setEmail("lhd");
          String salt = ToolUtils.getRandStr(6);
          passports.setSalt(salt);
          passports.setCreatedAt(new Date());
          passports.setUpdatedAt(new Date());
          passports.setPassword(AESUtil.aesEncode("lhd", salt));
          passportsMapper.insertSelective(passports);
      }

    @Test
    public void testInsert() {
        userPointService.testInsert();
    }


    @Test
    public void test001() {
        String k = EmojiUtil.parseToHtmlHexadecimal("rk\uD83E\uDD11");
        userPointService.testInsert(k);
    }


    @Test
    public void test002() {
        //Emoji字符不能的插入数据库
        userPointService.testInsert("rk\uD83E\uDD11");
    }



    @Test
    public void test003() {
        String k = EmojiUtil.parseToHtmlHexadecimal("rkpppp");
        userPointService.testInsert(k);
    }


    @Test
    public void test004() {
        UserPointExample example = new UserPointExample();
        example.createCriteria().andIdEqualTo(-1L);
        List<UserPoint> list = userPointMapper.selectByExample(example);
        List<Long> formIdList = newArrayList(transform(list, new Function<UserPoint, Long>() {
            @Override
            public Long apply(UserPoint userPoint) {
                return userPoint.getId();
            }
        }));
        formIdList.add(-1L);
        System.err.println(formIdList.toString());

    }




}
