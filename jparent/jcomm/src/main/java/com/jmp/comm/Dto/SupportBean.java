package com.jmp.comm.Dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-10-30 10:12
 * @ Description：区分service的类型
 */
@Data
public class SupportBean {

    private Integer supportNum;

    public SupportBean(Integer supportNum) {
        this.supportNum = supportNum;
    }
}
