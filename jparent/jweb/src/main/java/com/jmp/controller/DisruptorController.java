package com.jmp.controller;

import com.jmp.comm.Utils.JsonUtil;
import com.jmp.disruptor.model.DataResponseVo;
import com.jmp.disruptor.model.SeriesData;
import com.jmp.disruptor.queuehelper.SeriesDataEventQueueHelper;
import com.jmp.sql.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-09-12 18:32
 * @ Description：
 */
@RestController
@RequestMapping("/dis")
@Slf4j
public class DisruptorController {


    // 注入SeriesDataEventQueueHelper消息生产者
    @Autowired
    private SeriesDataEventQueueHelper seriesDataEventQueueHelper;



    // localhost:8888/dis/test
    @RequestMapping(value = {"/test"})
    public String getListData() throws Exception{
        seriesDataEventQueueHelper.publishEvent(new SeriesData("hello world ..."));
        log.info("test dis controller.....");
        return "ok";
    }








    @RequestMapping(value = "/data", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public DataResponseVo<String> receiverDeviceData(@RequestBody String deviceData) {
        long startTime1 = System.currentTimeMillis();

        if (StringUtils.isEmpty(deviceData)) {
            log.info("receiver data is empty !");
            return new DataResponseVo<String>(400, "failed");
        }
        seriesDataEventQueueHelper.publishEvent(new SeriesData(deviceData));
        long startTime2 = System.currentTimeMillis();
        log.info("receiver data ==[{}] millisecond ==[{}]", deviceData, startTime2 - startTime1);
        return new DataResponseVo<String>(200, "success");
    }
}
