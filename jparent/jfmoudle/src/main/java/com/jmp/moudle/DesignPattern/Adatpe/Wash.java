package com.jmp.moudle.DesignPattern.Adatpe;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-10-11 11:43
 * @ Description：
 */
public class Wash implements ThreeElectricOutlet {

    private String name;

    public Wash() {
        name = "sam洗衣机";
    }

    public Wash(String name) {

        this.name = name;
    }

    @Override
    public void connectElectricCurrent() {
        turnOn();
    }

    public void turnOn() {
        System.err.println(name + " 开始洗衣服啦");
    }
}
