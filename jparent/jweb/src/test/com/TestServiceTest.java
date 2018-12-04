package com;

import com.jmp.comm.Dto.SupportBean;
import com.jmp.service.Helper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-10-30 10:32
 * @ Description：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class TestServiceTest {

    @Autowired
    private Helper helper;

    @Test
    public void test001() {
    }

}
