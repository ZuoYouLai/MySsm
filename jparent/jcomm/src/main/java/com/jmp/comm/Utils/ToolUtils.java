package com.jmp.comm.Utils;

import org.joda.time.DateTime;

import java.util.Date;
import java.util.Random;

/**
 * Creator : LaiHaoDa
 * Date    : 2018-08-28 11:34
 */
public class ToolUtils {


    private final static char[] CHR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /**
     * 生成只有数字+字符的随机字符串
     *
     * @param length
     * @return
     */
    public static String getRandStr(int length) {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            buffer.append(CHR[random.nextInt(CHR.length)]);
        }
        return buffer.toString();
    }



    /**
     * 生成36位落地页随机码
     * @return
     */
    public static String getLandingPageCode() {
        String nowStr = new DateTime(new Date()).toString(Constant.DATE_YMDHMS);
        //22位随机字符 + 16位时间字符
        return getRandStr(22) + nowStr;
    }

    /**
     * 合并字符 生成一个redis key
     * @param prefix
     * @param suffix
     * @return
     */
    public static String getKey(String prefix, Object suffix) {
        return new StringBuilder().append(prefix).append("_").append(suffix.toString()).toString();
    }

}
