package com.jmp.jpojo;


/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-09-29 16:16
 * @ Description：
 */
public class DefineException extends RuntimeException {


    private static final long serialVersionUID = 1L;
    /**
     * 错误编码
     */
    private Integer errorCode;


    /**
     * 消息是否为属性文件中的Key
     */
    private boolean propertiesKey = true;

    /**
     * 构造一个基本异常.
     *
     * @param message
     *            信息描述
     */
    public DefineException(String message)
    {
        super(message);
    }


    /**
     * 构造一个基本异常.
     *
     * @param errorCode
     *            错误编码
     * @param message
     *            信息描述
     */
    public DefineException(Integer errorCode, String message)
    {
        this(errorCode, message, true);
    }

    /**
     * 构造一个基本异常.
     *
     * @param errorCode
     *            错误编码
     * @param message
     *            信息描述
     */
    public DefineException(Integer errorCode, String message, Throwable cause)
    {
        this(errorCode, message, cause, true);
    }

    /**
     * 构造一个基本异常.
     *
     * @param errorCode
     *            错误编码
     * @param message
     *            信息描述
     * @param propertiesKey
     *            消息是否为属性文件中的Key
     */
    public DefineException(Integer errorCode, String message, boolean propertiesKey)
    {
        super(message);
        this.setErrorCode(errorCode);
        this.setPropertiesKey(propertiesKey);
    }

    /**
     * 构造一个基本异常.
     *
     * @param errorCode
     *            错误编码
     * @param message
     *            信息描述
     */
    public DefineException(Integer errorCode, String message, Throwable cause, boolean propertiesKey)
    {
        super(message, cause);
        this.setErrorCode(errorCode);
        this.setPropertiesKey(propertiesKey);
    }

    /**
     * 构造一个基本异常.
     *
     * @param message
     *            信息描述
     * @param cause
     *            根异常类（可以存入任何异常）
     */
    public DefineException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isPropertiesKey()
    {
        return propertiesKey;
    }

    public void setPropertiesKey(boolean propertiesKey)
    {
        this.propertiesKey = propertiesKey;
    }
}
