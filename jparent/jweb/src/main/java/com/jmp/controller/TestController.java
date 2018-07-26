package com.jmp.controller;

import com.jmp.comm.Utils.JsonUtil;
import com.jmp.service.UserService;
import com.jmp.sql.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qiniu.ip17mon.LocationInfo;
import qiniu.ip17mon.Locator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @Resource
    UserService userService;


//    @RequestMapping(value = {"/list"}, produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    @RequestMapping(value = {"/list"})
    public String getListData() throws Exception{
        List<User> list = userService.getUserList();
        LOG.info("test controller.....");
        return JsonUtil.toJson(list);
    }



//    F:\Code\GitHub\MySsm\jparent\jweb\src\main\resources\17monipdb.datx
    // test/getIp
    @RequestMapping(value = {"/getIp"})
    public String getIp(HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        LOG.info("path : {}",TestController.class.getResource("").toString());
        LOG.info("path : {}",TestController.class.getResource("/").toString());
        LOG.info("path : {}",TestController.class.getResource("").getPath());
        LOG.info("path : {}",TestController.class.getResource("/").getPath());
        Locator locator = Locator.loadFromLocal(TestController.class.getResource("/").getPath()+"17monipdb.datx");
        LocationInfo ipInfo = locator.find("180.163.159.7");
        LOG.info("test ip.....");
        LOG.info("info country : {}",ipInfo.country);
        LOG.info("info is : {}",ipInfo.isp);
        LOG.info("info city : {}",ipInfo.city);
        return ipInfo.toString();
    }




}
