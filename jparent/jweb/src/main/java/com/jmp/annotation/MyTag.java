package com.jmp.annotation;

import java.lang.annotation.*;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-11-30 16:50
 * @ Description：参考链接：https://blog.csdn.net/majunzhu/article/details/79116057
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyTag {

    String tagName();

    String tagRole();

    String tagContent();
}
