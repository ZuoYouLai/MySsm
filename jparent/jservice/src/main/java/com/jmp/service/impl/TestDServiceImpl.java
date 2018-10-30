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
public class TestDServiceImpl implements TestService{
    @Override
    public void execute() {
        System.err.println(" D  execute");
    }

    @Override
    public int getPriority() {
        return 4;
    }

    @Override
    public boolean isSupport(SupportBean supportBean) {
        return supportBean.getSupportNum() % 3 == 1;
    }

}
