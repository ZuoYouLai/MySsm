package com.jmp.moudle.DesignPattern.Adatpe;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-10-11 13:46
 * @ Description：
 *
 *
 * 下列应用程序中，Application.java使用了适配器模式中所涉及的类，应用程序负责用Wash类创建一个对象来模拟一台洗衣机，使用TV类创建一个对象来模拟一台电视机
   使用ThreeElectricOutlet接口变量调用Wash对象的connectElectricCurrent()方法，并借助适配器调用TV对象的connectElectricCurrent()方法，即用三厢插座分别为洗衣机和电视机接通电流。
 */
public class Application {
    public static void main(String[] args) {
        ThreeElectricOutlet outlet;
        Wash wash = new Wash();
        outlet = wash;
        System.out.println("使用三相插座接通电流");
        outlet.connectElectricCurrent();

        TV tv = new TV();
        ThreeElectricAdapter adapter = new ThreeElectricAdapter(tv);
        outlet = adapter;
        System.out.println("使用三相插座接通电流");
        outlet.connectElectricCurrent();
    }
}
