package com.jmp.jpojo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * 本类做数据结构的校验
 * JSR提供的校验注解：
         @Null   被注释的元素必须为 null
         @NotNull    被注释的元素必须不为 null
         @AssertTrue     被注释的元素必须为 true
         @AssertFalse    被注释的元素必须为 false
         @Min(value)     被注释的元素必须是一个数字，其值必须大于等于指定的最小值
         @Max(value)     被注释的元素必须是一个数字，其值必须小于等于指定的最大值
         @DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值
         @DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值
         @Size(max=, min=)   被注释的元素的大小必须在指定的范围内
         @Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内
         @Past   被注释的元素必须是一个过去的日期
         @Future     被注释的元素必须是一个将来的日期
         @Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式

         Hibernate Validator提供的校验注解：
         @NotBlank(message =)   验证字符串非null，且长度必须大于0
         @Email  被注释的元素必须是电子邮箱地址
         @Length(min=,max=)  被注释的字符串的大小必须在指定的范围内
         @NotEmpty   被注释的字符串的必须非空
         @Range(min=,max=,message=)  被注释的元素必须在合适的范围内
 *
 *
 *
 */
@Data
public class ValidaTestBean {

    @NotNull(message = "id不能为空...")
    private Integer id;

    @NotEmpty
    @Length(min = 0,max = 10,message = "name的长度需要在0到10区间")
    private String name;

    @Range(min = 0,max = 200,message = "age的年龄长度不能超过0到200的区间")
    private Integer age;

    @Length(max = 5)
    private String content;

    @Past
    private Date creatDate;

    @Future
    private Date update;


    public ValidaTestBean(Integer id, String name, Integer age, String content, Date creatDate, Date update) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.content = content;
        this.creatDate = creatDate;
        this.update = update;
    }


    public ValidaTestBean() {
    }
}
