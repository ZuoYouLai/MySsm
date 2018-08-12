package com.jmp.moudle.Thread.FuturePattern;


import com.google.common.base.Objects;

public class RealData implements Data{

    private String result;

    public RealData(String queryStr) {
        System.out.println("根据参数: " + queryStr + " 进行查询，这是一个很耗时的操作！");
        try {
            Thread.sleep(Objects.equal(queryStr,"samlai")?2000:3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("装载完毕，获取结果");
        result = queryStr + " : A001  [thread name : " + Thread.currentThread().getName() + "]";
    }

    @Override
    public String getRequest() {
        return result;
    }
}
