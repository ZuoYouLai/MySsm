package com.jmp.qrcontroller;
package com.jmp.qrcontroller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jmp.comm.Utils.Constant;
import com.jmp.comm.Utils.ResultUtils;
import com.jmp.comm.Utils.ToolUtils;
import com.jmp.redis.JedisService;
import com.jmp.service.LoginService;
import com.jmp.sql.domain.Passports;
import com.jmp.sql.domain.PassportsExample;
import com.jmp.sql.mapper.PassportsMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.tools.Tool;
import java.util.concurrent.TimeUnit;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-12-14 16:23
 * @ Description：
 */
@RestController
@Slf4j
public class LoginController {


}
