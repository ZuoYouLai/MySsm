package com.jmp.disruptor.queuehelper;

import com.jmp.disruptor.model.SeriesDataEvent;
import com.lmax.disruptor.EventFactory;

/**
 * @author chenyuanjun
 * @create 2018-01-18 下午6:24
 * @description
 * @SpecialThanksTo xielongwang
 */
public class MyEventFactory implements EventFactory<SeriesDataEvent> {
    @Override
    public SeriesDataEvent newInstance() {
        return new SeriesDataEvent();
    }
}
