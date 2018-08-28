package com.jmp.moudle.Guava;

import java.util.Objects;

public class ObjectTest {

    public static void main(String[] args) {
        boolean f1=Objects.equals("a", "a");
        System.err.println(f1);
        boolean f2=Objects.equals(null, "a");
        System.err.println(f2);
        boolean f3=Objects.equals("a", null);
        System.err.println(f3);
        boolean f4=Objects.equals(null, null);
        System.err.println(f4);


        boolean f6=Objects.equals(new Integer(5), 5);
        System.err.println("new Integer(5) == 5 " + f6);
        System.err.println("new Integer(5) == 5 "+(new Integer(5) == 5));

        boolean f7=Objects.equals(new Integer(5), new Integer(5));
        System.err.println("new Integer(5) == new Integer(5) " + f7);
        System.err.println("new Integer(5) == new Integer(5) "+(new Integer(5) == new Integer(5)));






        boolean f71=Objects.equals(null, 5);
        System.err.println("null == 5 " + f71);
    }



}
