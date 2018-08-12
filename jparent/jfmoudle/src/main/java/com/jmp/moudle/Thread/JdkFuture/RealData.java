package com.jmp.moudle.Thread.JdkFuture;


import java.util.concurrent.Callable;

public class RealData implements Callable<String> {

    private String param;

    public RealData(String param) {
        this.param = param;
    }

    @Override
    public String call() throws Exception {
        StringBuilder builder = new StringBuilder();
        for (int k = 0; k < 10; k++) {
            builder.append(param);
            Thread.sleep(100);
        }
        return builder.toString();
    }

}
