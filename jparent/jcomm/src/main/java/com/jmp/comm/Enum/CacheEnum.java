package com.jmp.comm.Enum;

/**
 * Creator : LaiHaoDa
 * Date    : 2018-08-28 11:28
 */
public enum CacheEnum {

    SIMPLE("simple_user", "simple redis cache"),
    SYNLOCK("syn_user", "synchronized redis cache"),
    LOCK("lock_user", "lock redis cache"),;

    private String key;
    private String desc;

    CacheEnum(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public String getKey() {

        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
