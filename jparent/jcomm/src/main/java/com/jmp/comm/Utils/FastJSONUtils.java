package com.jmp.comm.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.*;

import java.util.Objects;

/**
 * @description:FastJSON JSON数据处理工具类;
 * @author:liujun
 * @date: 2018-06-06 16:01
 */
public class FastJSONUtils {
    /**
     * @description:获取JsonHelper对象,主要使用该对象进行json序列化/反序列化相关操作;
     * @return com.shushangyunapi.utils.FastJSONUtils.JsonHelper对象
     * @author:liujun
     * @date: 2018-06-11 09:36
     */
    public static JsonHelper getJsonHelper() {
        return new JsonHelper();
    }

    /**
     * @description:FsstJSON序列化/反序列化工具类核心实现;
     * @author:liujun
     * @date: 2018-06-11 09:36
     */
    public static class JsonHelper {
        /**
         * FastJSON--JSONSerializer；
         */
        private JSONSerializer serializer;
        /**
         * FastJSON--SerializeWriter；
         */
        private SerializeWriter out;
        /**
         * 时间日期格式，默认为:yyyy-MM-dd HH:mm:ss;
         */
        private String datetimeFormat = Constant.DATE_YMD_HMS;
        /**
         * 是否序列化null值，默认为：true;
         */
        private boolean enableNullValue = true;

        public JsonHelper() {
            this.out = new SerializeWriter();
            this.serializer = new JSONSerializer(this.out);
        }

        /**
         * @description:注册值过滤器,用于序列化时针对特定值的操作;
         * @param filter ValueFilter
         * @return JsonHelper
         * @author:liujun
         * @date: 2018-06-11 09:50
         */
        public JsonHelper registerValueFilter(ValueFilter filter) {
            this.serializer.getValueFilters().add(filter);

            return this;
        }
        
        /**
         * @description:注册key处理器,用于序列化时针对特定key的操作;
         * @param filter NameFilter
         * @return JsonHelper
         * @author:liujun
         * @date: 2018-06-11 09:50
         */
        public JsonHelper registerNameFilter(NameFilter filter) {
            this.serializer.getNameFilters().add(filter);

            return this;
        }
        
        /**
         * @description:Java对象序列化为JSON格式字符串;
         * @param object Java对象
         * @return JSON格式字符串
         * @author:liujun
         * @date: 2018-06-11 10:07
         */
        public String toJSONString(Object object) {
            return toJSONString(object, false);
        }
        
        /**
         * @description:Java对象序列化为JSON格式字符串;
         * @param object Java对象
         * @param prettyFormat 是否格式化json
         * @return JSON格式字符串
         * @author:liujun
         * @date: 2018-06-11 10:07
         */
        public String toJSONString(Object object, boolean prettyFormat) {
            try {
                initDefaultJSONSerializer(this.serializer);
                serializer.config(SerializerFeature.PrettyFormat, prettyFormat);
                serializer.write(object);

                return out.toString();
            } finally {
                out.close();
            }
        }

        /**
         * @description:
         * @author:liujun
         * @date: 2018-06-11 11:19
         */
        public <T> T toJavaBean(String json, Class<T> clazz) {
            return JSON.toJavaObject(JSON.parseObject(json), clazz);
        }
    
        /**
         * @description:
         * @author:liujun
         * @date: 2018-06-11 11:27
         */
        public JSONObject toJSONObject(String json) {
            return JSON.parseObject(json);
        }

        /**
         * @description:
         * @author:liujun
         * @date: 2018-06-11 11:44
         */
        public JSONArray toJSONArray(String json) {
            return JSON.parseArray(json);
        }
        
        /**
         * @description:
         * @author:liujun
         * @date: 2018-06-11 12:22
         */
        public Object toObject(String json) {
            return JSON.parseObject(json);
        }

        /**
         * @description:初始化默认JSON序列化行为;
         * @author:liujun
         * @date: 2018-06-11 10:40
         */
        private void initDefaultJSONSerializer(JSONSerializer serializer) {
            Objects.requireNonNull(serializer, "The parameter 'serializer' mustn't be null");

            // 格式化时间日期;
            serializer.config(SerializerFeature.WriteDateUseDateFormat, true);
            serializer.setDateFormat(datetimeFormat);
            // 序列化null值;
            serializer.config(SerializerFeature.WriteMapNullValue, enableNullValue);
        }

        public JsonHelper setDatetimeFormat(String datetimeFormat) {
            this.datetimeFormat = datetimeFormat;

            return this;
        }

        public JsonHelper setEnableNullValue(boolean enableNullValue) {
            this.enableNullValue = enableNullValue;

            return this;
        }

    }

}
