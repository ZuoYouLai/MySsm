package com.jmp.comm.Utils;

/**
 * Creator : LaiHaoDa
 * Date    : 2018-08-28 11:34
 */
public class ToolUtils {

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
