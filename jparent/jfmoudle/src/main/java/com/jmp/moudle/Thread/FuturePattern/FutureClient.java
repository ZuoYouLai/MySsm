package com.jmp.moudle.Thread.FuturePattern;

public class FutureClient {
    public Data getRequest(final String queryStr) {
        final FutureData futureData = new FutureData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                RealData realData = new RealData(queryStr);
                futureData.setRealData(realData);
            }
        }).start();
        System.err.println("代理对象 返回 : " + futureData);
        return futureData;
    }
}
