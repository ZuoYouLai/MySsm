package com.jmp.service;

import com.jmp.comm.Dto.SupportBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-10-30 10:20
 * @ Description：service的工具类内容
 */
@Component
public class Helper {

    @Autowired
    private List<TestService> testServiceList;

    public void execute(SupportBean supportBean) {
        TestService service = testServiceList.stream().filter(x -> x.isSupport(supportBean))
                .sorted(Comparator.comparing(TestService::getPriority))
                .map(Optional::ofNullable)
                .findFirst()
                .flatMap(Function.identity())
                .orElse(null);
        if (service != null) {
            service.execute();
        }
        System.err.println(service);
    }
}
