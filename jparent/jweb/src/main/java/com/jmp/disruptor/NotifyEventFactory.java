package com.jmp.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-09-12 17:48
 * @ Description：创建消息工厂用于生产消息
 */
public class NotifyEventFactory implements EventFactory{
    @Override
    public Object newInstance() {
        return new NotifyEvent();
    }
}
