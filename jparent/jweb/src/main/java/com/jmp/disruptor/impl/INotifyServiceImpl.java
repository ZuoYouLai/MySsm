package com.jmp.disruptor.impl;

import com.jmp.disruptor.*;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-09-12 18:09
 * @ Description：整合Spring，对Disruptor进行初始化
 */
@Service("iNotifyService")
public class INotifyServiceImpl implements INotifyService, DisposableBean, InitializingBean {

    private Disruptor<NotifyEvent> disruptor;
    private static final int ring_buffer_size = 1024 * 1024;


    @Override
    public void sendNotify(String message) {
        RingBuffer<NotifyEvent> ringBuffer = disruptor.getRingBuffer();
//        ringBuffer.publishEvent(new EventTranslatorOneArg<NotifyEvent,  String>() {
//            @Override
//            public void translateTo(NotifyEvent event, long sequence, String data) {
//                event.setMessage(data);
//            }
//        }, message);
        ringBuffer.publishEvent((event, sequence, data) -> event.setMessage(data), message); //lambda式写法，如果是用jdk1.8以下版本使用以上注释的一段

    }

    @Override
    public void destroy() throws Exception {
        disruptor.shutdown();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        disruptor = new Disruptor<NotifyEvent>(new NotifyEventFactory(), ring_buffer_size, Executors.defaultThreadFactory(), ProducerType.SINGLE, new BlockingWaitStrategy());
        disruptor.setDefaultExceptionHandler(new NotifyEventHandlerException());
        disruptor.handleEventsWith(new NotifyEventHandler());
        disruptor.start();
    }
}
