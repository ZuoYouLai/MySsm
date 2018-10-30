package com.jmp.service.impl;

import com.jmp.comm.Dto.SupportBean;
import com.jmp.service.TestService;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-10-30 10:14
 * @ Description：
 */
@Component
public class TestCServiceImpl implements TestService{
    @Override
    public void execute() {
        System.err.println(" C  execute");
    }

    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public boolean isSupport(SupportBean supportBean) {
        return supportBean.getSupportNum() % 3 == 2;
    }

}
