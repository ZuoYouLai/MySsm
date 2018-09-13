package com.jmp.disruptor.handler;

import com.jmp.disruptor.biz.DeviceInfoService;
import com.jmp.disruptor.model.SeriesDataEvent;
import com.lmax.disruptor.WorkHandler;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

@Slf4j
@Data
public class SeriesDataEventHandler implements WorkHandler<SeriesDataEvent> {

    private int clusterNo;


    public SeriesDataEventHandler() {
    }

    public SeriesDataEventHandler(int clusterNo) {
        super();
        this.clusterNo = clusterNo;
    }

    @Autowired
    private DeviceInfoService deviceInfoService;

    @Override
    public void onEvent(SeriesDataEvent event)  {
        if (event.getValue() == null || StringUtils.isEmpty(event.getValue().getDeviceInfoStr())) {
            log.warn("receiver series data is empty!");
        }
        biz(clusterNo);
        //业务处理
        deviceInfoService.processData("CLUSTERNO[" + clusterNo + "]" + event.getValue().getDeviceInfoStr());
    }
    
    private void biz(int clusterNo) {
        log.info("Start proceeding @ CLUSTERNO[" + clusterNo + "]...");
        //blablabla
    }
}