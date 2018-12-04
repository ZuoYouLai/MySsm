package com.jmp.biz;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-12-04 11:32
 * @ Description：读取全局的property文件的配置内容
 */
@Getter
@Component
public class Config {

    @Value("${file.path}")
    private String localFilePath;


    @Value("${file.base.url}")
    private String basePath;

}
