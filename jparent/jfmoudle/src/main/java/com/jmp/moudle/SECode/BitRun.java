package com.jmp.moudle.SECode;

import java.io.UnsupportedEncodingException;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-09-18 15:24
 * @ Description：
 */
public class BitRun {

    private static Byte[] keyBytes = new Byte[]{'a', 'n', 'l'};

    public static void main(String[] args) throws UnsupportedEncodingException {

        swap(100, 200);
        System.err.println("100 是奇数嘛?  答案是 : " + isOddNumber(100));
        System.err.println("101 是奇数嘛?  答案是 : " + isOddNumber(101));


        System.err.println(mulTwo(2));
        System.err.println(divTwo(100));
        System.err.println(mulTwoPower(1, 2));
        System.err.println(divTwoPower(100, 2));


        String one = "sdasda";
        int key = 10;
        String target = encode(one, key);
        String tone = encode(target, key);
        System.err.println("target  :  " + target);
        System.err.println("tone  :  " + tone);


        System.err.println("19343   :    " + decimalToHex(19343));

    }


    /**
     * 对称加密
     *
     * @param source
     * @param key
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String encode(String source, int key) throws UnsupportedEncodingException {
        byte[] b = source.getBytes("UTF-8");
        for (int i = 0, size = b.length; i < size; i++) {
            for (byte keyBytes0 : keyBytes) {
                b[i] = (byte) (b[i] ^ key);
            }
        }
        return new String(b);
    }


    /**
     * 用异或来进行交换数值
     *
     * @param a
     * @param b
     */
    public static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.err.println("a  =  " + a);
        System.err.println("b  =  " + b);
    }


    //判断数值的奇偶性
    public static boolean isOddNumber(int n) {
        return (n & 1) == 1;
    }


    //计算n*2
    public static int mulTwo(int n) {
        return n << 1;
    }

    //除以2，负奇数的运算不可用
    public static int divTwo(int n) {
        return n >> 1;//除以2
    }

    //计算n*(2^m)，即乘以2的m次方
    public static int mulTwoPower(int n, int m) {
        return n << m;
    }

    //计算n/(2^m)，即除以2的m次方
    public static int divTwoPower(int n, int m) {
        return n >> m;
    }



    public static String decimalToHex(int decimal) {
        String hex = "";
        while (decimal != 0) {
            int hexValue = decimal % 16;
            hex = toHexChar(hexValue) + hex;
            decimal = decimal / 16;
        }
        return  hex;
    }

    //将0~15的十进制数转换成0~F的十六进制数
    public static char toHexChar(int hexValue) {
        if(hexValue <= 9 && hexValue >= 0) {
            return (char)(hexValue + '0');
        } else {
            return (char)(hexValue - 10 + 'A');
        }
    }
}
