package com.jmp.comm.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.joda.time.DateTime;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
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


    /**
     * 获取年月日的连接符号
     * @return
     */
    public static String getSysYearAndMonthAndDay() {
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        String month = String.valueOf(date.get(Calendar.MONTH) + 1);
        String day = String.valueOf(date.get(Calendar.DAY_OF_MONTH));
        String url = year + "/" + month + "/" + day;
        return url;
    }


    /**
     * 判断字符是否json格式
     * @param content
     * @return
     */
    public static Boolean isJson(String content) {
        try {
            Object jsonObject = JSONObject.parse(content);
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }


    /**
     * @author samLai
     * @date 2018/12/14 17:49
     * @params [message]
     * @Description : 返回相应错误的信息内容
     */
    public static void error(String message) {
        throw new RuntimeException(message);
    }



    /**
     * 将一个java bean生成一个json object内容
     *
     * @param object
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T objectToJson(Object object, Class<T> cls) {
        String jsonStr = JSON.toJSONString(object);
        return JSON.parseObject(jsonStr, cls);
    }




    /**
     获取的真实的ip地址
     */
    public static String getRealIpAddress(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
    }

}
