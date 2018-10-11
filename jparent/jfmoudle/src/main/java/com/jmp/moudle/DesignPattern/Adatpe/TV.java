package com.jmp.moudle.DesignPattern.Adatpe;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-10-11 13:44
 * @ Description：
 */
public class TV implements TwoElectricOutlet {

    private String name;

    public TV() {
        name = "sam电视机";
    }

    public TV(String name) {
        this.name = name;
    }

    @Override
    public void connectElectricCurrent() {
        turnOn();
    }
    public void turnOn() {
        System.err.println(name + " 开始播电视啦啦");
    }
}
