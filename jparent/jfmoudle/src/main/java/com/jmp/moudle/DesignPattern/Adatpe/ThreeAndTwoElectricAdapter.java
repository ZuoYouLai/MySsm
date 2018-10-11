package com.jmp.moudle.DesignPattern.Adatpe;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-10-11 13:54
 * @ Description：
 */
public class ThreeAndTwoElectricAdapter implements ThreeElectricOutlet,TwoElectricOutlet {

    private ThreeElectricOutlet threeElectricOutlet;
    private TwoElectricOutlet twoElectricOutlet;

    public ThreeAndTwoElectricAdapter(ThreeElectricOutlet threeElectricOutlet, TwoElectricOutlet twoElectricOutlet) {
        this.threeElectricOutlet = threeElectricOutlet;
        this.twoElectricOutlet = twoElectricOutlet;
    }

    @Override
    public void connectElectricCurrent() {
        if (this instanceof ThreeElectricOutlet) {
            twoElectricOutlet.connectElectricCurrent();
        }

        if (this instanceof TwoElectricOutlet) {
            threeElectricOutlet.connectElectricCurrent();
        }
    }

    public static void main(String[] args) {
        ThreeElectricOutlet threeElectricOutlet;
        TwoElectricOutlet twoElectricOutlet;
        Wash wash = new Wash();
        TV tv = new TV();
        ThreeAndTwoElectricAdapter adapter = new ThreeAndTwoElectricAdapter(wash, tv);
        threeElectricOutlet = adapter;
        System.err.println("使用三厢插座接通电源");
        threeElectricOutlet.connectElectricCurrent();
        twoElectricOutlet = adapter;
        System.err.println("使用两厢插座接通电源");
        twoElectricOutlet.connectElectricCurrent();
    }
}
