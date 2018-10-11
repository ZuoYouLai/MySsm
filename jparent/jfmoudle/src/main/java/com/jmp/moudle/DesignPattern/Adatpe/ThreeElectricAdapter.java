package com.jmp.moudle.DesignPattern.Adatpe;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-10-11 11:40
 * @ Description：适配器：实现目标接口
 */
public class ThreeElectricAdapter implements ThreeElectricOutlet {
    //适配器包含被适配者的引用
    private TwoElectricOutlet outlet;

    public ThreeElectricAdapter(TwoElectricOutlet outlet) {
        this.outlet = outlet;
    }

    @Override
    public void connectElectricCurrent() {
        outlet.connectElectricCurrent();
    }
}
