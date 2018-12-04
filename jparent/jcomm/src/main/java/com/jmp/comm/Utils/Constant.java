package com.jmp.comm.Utils;

import com.alibaba.fastjson.serializer.SerializerFeature;

public class Constant {

    public static final String DATE_YMD_HMS = "yyyy-MM-dd HH:mm:ss";

    public final static String DATE_YMD = "yyyy-MM-dd";

    public final static String DATE_YMDHMS = "yyyyMMddHHmmss";


    /**
     * 统一的请求内容
     */
    public static final String HTTP_PRODUCE = "application/json;charset=utf-8";



    /**
     * 全平台,Alibaba FastJSON框架默认序列化行为;
     */
    public static final SerializerFeature[] DEFAULT_FAST_JSON_SERIALIZER_FEATURE = new SerializerFeature[]{
            // 序列化值为null的字符串为空串("");
            SerializerFeature.WriteNullStringAsEmpty,
            // 序列化null字段;
            SerializerFeature.WriteMapNullValue,
            // 序列化值为null的集合为空集合([]);
            SerializerFeature.WriteNullListAsEmpty
    };

}
