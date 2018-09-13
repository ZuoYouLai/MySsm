/**  
 * @Title: DeviceInfoService.java   
 * @Package: yuanjun.chen.disruptor   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年9月7日 下午2:40:01   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package com.jmp.disruptor.biz;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**   
 * @ClassName: DeviceInfoService   
 * @date: 2018年9月7日 下午2:40:01
 */
@Service
@Slf4j
public class DeviceInfoService {

    public void processData(String deviceInfoStr) {
        log.info("Received data---" + deviceInfoStr + " and prepare to Persisit!");
    }
}
