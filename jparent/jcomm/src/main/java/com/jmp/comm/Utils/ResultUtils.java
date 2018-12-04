package com.jmp.comm.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @description:接口返回数据封装,后台返回的数据原则上必须使用该类封装;
 */
public final class ResultUtils {
    /**
     * 接口返回数据默认时间日期格式;
     */
    private static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 接口请求状态,true/false;
     */
    private Boolean success;
    /**
     * 接口请求状态码,200成功,422后台错误,更多状态码,参考接口文档说明;
     */
    private Integer code;
    /**
     * 接口返回提示信息;
     */
    private String msg;
    /**
     * 接口返回数据;
     */
    private Object data;

    private ResultUtils() {super();}

    private ResultUtils(Boolean success, Integer code, String messege, Object data) {
        super();
        this.code = code;
        this.success = success;
        this.msg = messege;
        this.data = data;
    }

    /**
     * @description:接口请求成功返回提示信息,无数据返回;
     * @param message 接口返回提示信息
     * @return ResultUtils对象

     */
    public static ResultUtils success(String message) {
        return new ResultUtils(true, 200, message, null);
    }

    /**
     * @description:接口请求成功返回提示信息,无数据返回;
     * @param message 接口返回提示信息
     * @return JSON格式数据

     */
    public static String successJSON(String message) {
        return FastJSONUtils.getJsonHelper().toJSONString(success(message));
    }

    /**
     * @description:接口请求成功数据返回;
     * @param data 接口返回数据
     * @return ResultUtils对象

     */
    public static ResultUtils success(Object data) {
        return new ResultUtils(true, 200, null, data);
    }

    /**
     * @description:接口请求成功数据返回;
     * @param data 接口返回数据
     * @return JSON格式数据

     */
    public static String successJSON(Object data) {
        return FastJSONUtils.getJsonHelper().toJSONString(success(data));
    }

    /**
     * @description:接口请求成功数据返回;
     * @param data 接口返回数据
     * @param message 接口返回提示信息
     * @return ResultUtils对象

     */
    public static ResultUtils success(Object data, String message) {
        return new ResultUtils(true, 200, message, data);
    }

    /**
     * @description:接口请求成功数据返回;
     * @param data 接口返回数据
     * @param message 接口返回提示信息
     * @return JSON格式数据

     */
    public static String successJSON(Object data, String message) {
        return FastJSONUtils.getJsonHelper().toJSONString(success(data, message));
    }

    public static String successJSON(Object data, String message, String[] fildArr) {
        Object  target=objectByField(data, fildArr);
        return JSON.toJSONStringWithDateFormat(success(target, message), DEFAULT_DATE_TIME_FORMAT, Constant.DEFAULT_FAST_JSON_SERIALIZER_FEATURE);
    }

    /**
     * @description:接口请求成功数据返回;
     * @param message 提示信息
     * @param data 返回数据
     * @param code 返回状态码
     * @return ResultUtils对象

     */
    public static ResultUtils success(Object data, Integer code, String message) {
        return new ResultUtils(true, code, message, data);
    }

    /**
     * @description:接口请求成功数据返回;
     * @param message 提示信息
     * @param data 返回数据
     * @param code 返回状态码
     * @return JSON格式数据

     */
    public static String successJSON(Object data, Integer code, String message) {
        return FastJSONUtils.getJsonHelper().toJSONString(success(data, code, message));
    }


    public static String successJSON(Object data, Integer code, String message, String[] fildArr) {
        Object  target=objectByField(data, fildArr);
        return JSON.toJSONStringWithDateFormat(success(target, code, message), DEFAULT_DATE_TIME_FORMAT, Constant.DEFAULT_FAST_JSON_SERIALIZER_FEATURE);
    }

    /**
     * @description:接口请求失败数据返回;
     * @param message 接口返回提示信息
     * @return ResultUtils对象

     */
    public static ResultUtils fail(String message) {
        return new ResultUtils(false, 422, message, null);
    }
    
    /**
     * @description:接口请求失败数据返回;
     * @param message 接口返回提示信息
     * @return JSON格式数据

     */
    public static String failJSON(String message) {
        return FastJSONUtils.getJsonHelper().toJSONString(fail(message));
    }

    /**
     * @description:接口请求失败数据返回;
     * @param message 提示信息
     * @param code 状态码
     * @return ResultUtils对象

     */
    public static ResultUtils fail(String message, Integer code) {
        return new ResultUtils(false, code, message, null);
    }

    /**
     * @description:接口请求失败数据返回;
     * @param message 提示信息
     * @param code 状态码
     * @return JSON格式数据

     */
    public static String failJSON(String message, Integer code) {
        return FastJSONUtils.getJsonHelper().toJSONString(fail(message, code));
    }


    /**
     * @description:接口请求成功数据返回;
     * @param data 返回数据
     * @return JSON格式数据
     * @author:laihaoda
     * @date: 2018-05-15
     */
    public static String successJSON(Object data, String[] fildArr) {
        Object target=objectByField(data, fildArr);
        return JSON.toJSONStringWithDateFormat(success(target), DEFAULT_DATE_TIME_FORMAT, Constant.DEFAULT_FAST_JSON_SERIALIZER_FEATURE);
    }



    /**
     * 将需要组装的data对象进行再次组装给前端所识别
     * @param data   对象
     * @param fildArr 需要转义对应key集合
     * @return 前端需要的json对象格式
     * @author:laihaoda
     * @date: 2018-05-15
     */
    public static Object objectByField(Object data, String[] fildArr){
        Object object= JSON.parse(JSON.toJSONStringWithDateFormat(data, DEFAULT_DATE_TIME_FORMAT));
        if(object instanceof JSONObject){
            return getJsonObj((JSONObject)object, fildArr);
        }else if(object instanceof JSONArray){
            JSONArray array = (JSONArray)object,
                      newArray=new JSONArray();
            for(Object oneObj:array){
                JSONObject oneJsonObj= JSON.parseObject(JSON.toJSONString(oneObj));
                JSONObject newOne=getJsonObj(oneJsonObj, fildArr);
                newArray.add(newOne);
            }
            return newArray;
        }
        return object;
    }


    /**
     * 将单个对象转变为前端
     * @param object
     * @param fildArr
     * @return
     */
    private static JSONObject getJsonObj(JSONObject object, String[] fildArr){
        for(String str:fildArr){
            Object oj=object.get(str);
            if( oj!=null  && (oj instanceof String)){
                if (ToolUtils.isJson(oj.toString())) {
                    Object chobj= JSON.parse(oj.toString());
                    object.put(str,chobj);
                } else {
                    object.put(str, oj.toString());
                }
            }
        }
        return object;
    }


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
