package com.jmp.comm.Utils;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.StdSerializerProvider;
import org.codehaus.jackson.map.ser.std.NullSerializer;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;


public class JsonUtil {
    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);
    private final static ObjectMapper objectMapper;

    static {
        StdSerializerProvider sp = new StdSerializerProvider();
        sp.setNullValueSerializer(NullSerializer.instance);
        objectMapper = new ObjectMapper(null, sp, null);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.INTERN_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    /**
     * JSON字符串转换为Java泛型对象
     * 例1：String jsonStr = "[{\"id\":\"1234\",\"account\":\"admin\"}]";
     * List<UserInfo> list = JsonUtil.json2GenericObject(jsonStr, new TypeReference<List<UserInfo>>() {});
     * 例2：String jsonStr = "[\"1111\",\"2222\",\"3333\"]";
     * List<String> list = JsonUtil.json2GenericObject(jsonStr, new TypeReference<List<String>>() {});
     * @param <T> 转换泛型
     * @param jsonString JSON字符串
     * @param tr 需要转换的对象类型
     * @return Java泛型对象
     */
    public synchronized static <T> T json2GenericObject(String jsonString, TypeReference<T> tr) {
        if (jsonString != null && !("".equals(jsonString))) {
            try {
                return (T) (tr.getType().equals(String.class) ? jsonString : objectMapper.readValue(jsonString, tr));
            } catch (Exception e) {
                log.warn("json error:" + e.getMessage());
            }
        }
        return null;
    }

    /**
     * Java对象转Json字符串
     * @param object Java对象，可以是对象，数组，List,Map等
     * @return json 字符串
     */
    public synchronized static String toJson(Object object) {
        String jsonString = "";
        try {
            jsonString = objectMapper.writeValueAsString(object);
            if (log.isDebugEnabled()) {
                log.debug(jsonString);
            }
        } catch (Exception e) {
            log.warn("json error:" + e.getMessage());
        }
        return jsonString;
    }

    /**
     * Json字符串转Java对象
     * @param jsonString json字符串
     * @param clazz java类
     * @return
     * @deprecated
     */
    public synchronized static Object json2Object(String jsonString, Class<?> clazz) {
        if (jsonString != null && !("".equals(jsonString))) {
            try {
                return objectMapper.readValue(jsonString, clazz);
            } catch (Exception e) {
                log.warn("json error:" + e.getMessage());
            }
        }
        return "";
    }

    /**
     * JSON字符串转java对象
     * @param <T> 转换泛型
     * @param jsonStr JSON字符串
     * @param clazz 类型
     * @return java对象
     */
    public synchronized static <T> T json2Java(String jsonStr, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonStr, clazz);
        } catch (IOException e) {
            log.warn("json error:" + e.getMessage());
            return null;
        }

    }
}
