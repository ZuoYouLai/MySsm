package com.jmp.service;

import com.jmp.comm.Dto.SupportBean;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-10-30 10:09
 * @ Description：动态的根据service来执行相应的服务内容  不使用if ... else  ...
 */
public interface TestService {
    void execute();

    int getPriority();

    boolean isSupport(SupportBean supportBean);
}
