package com.jmp.disruptor;

import com.jmp.comm.Utils.ToolUtils;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-09-12 17:52
 * @ Description：创建消费者，此处用于处理业务逻辑
 */
public class NotifyEventHandler implements EventHandler<NotifyEvent>,WorkHandler<NotifyEvent>{

    @Override
    public void onEvent(NotifyEvent notifyEvent) throws Exception {
        System.err.println(notifyEvent + "  >   " + ToolUtils.getRandStr(6));
    }

    @Override
    public void onEvent(NotifyEvent notifyEvent, long l, boolean b) throws Exception {
        System.err.println("接收信息");
        this.onEvent(notifyEvent);
    }

}
