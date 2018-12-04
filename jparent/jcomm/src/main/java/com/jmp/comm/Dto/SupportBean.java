package com.jmp.comm.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-10-30 10:12
 * @ Description：区分service的类型
 */
@Data
@ToString
@NoArgsConstructor
public class SupportBean {

    private Integer supportNum;

//    public SupportBean(Integer supportNum) {
//        this.supportNum = supportNum;
//    }

    public static void main(String[] args) {
        System.err.println(new SupportBean());
//        System.err.println(new SupportBean(11));
    }
}
