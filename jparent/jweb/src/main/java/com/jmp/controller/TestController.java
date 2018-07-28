package com.jmp.controller;

import com.jmp.comm.Utils.JsonUtil;
import com.jmp.jpojo.ValidaTestBean;
import com.jmp.service.UserService;
import com.jmp.sql.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import qiniu.ip17mon.LocationInfo;
import qiniu.ip17mon.Locator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



    @RequestMapping(value = {"/valid"})
    public String testParams(@RequestBody @Valid ValidaTestBean validaTestBean){
        LOG.info("valid bean data : {}", JsonUtil.toJson(validaTestBean));
        return "ok";
    }


    @RequestMapping(value = {"/zf"})
    public String zfTest(String name) {
        Map map = new HashMap();
        map.put("name", name);
        map.put("赖", "好哒");
        LOG.info("data :{}",JsonUtil.toJson(map));
        return JsonUtil.toJson(map);
    }




    @RequestMapping(value = {"/zf1"})
    public void zfTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        Map map = new HashMap();
        map.put("name", "ni核实name");
        map.put("赖", "好哒");
        LOG.info("data :{}",JsonUtil.toJson(map));
        response.getWriter().write(JsonUtil.toJson(map));
        response.getWriter().flush();
    }



    @RequestMapping(value = {"/reqbody1"})
    public String reqbody1(String name) {
        List<Map> listMap = new ArrayList<Map>();
        Map map1 = new HashMap();
        map1.put("kk","lop");
        listMap.add(map1);
        listMap.add(map1);
        listMap.add(map1);
        Map map = new HashMap();
        map.put("name", name);
        map.put("list", listMap);
        map.put("list2", JsonUtil.toJson(map));
        map.put("赖", "好哒");
        LOG.info("data :{}",JsonUtil.toJson(map));
        return JsonUtil.toJson(map);
    }


    @RequestMapping(value = {"/reqbody"})
    @ResponseBody
    public String reqbody(String name) {
        List<Map> listMap = new ArrayList<Map>();
        Map map1 = new HashMap();
        map1.put("kk","lop");
        listMap.add(map1);
        listMap.add(map1);
        listMap.add(map1);
        Map map = new HashMap();
        map.put("name", name);
        map.put("list", listMap);
        map.put("list2", JsonUtil.toJson(map));
        map.put("赖", "好哒");
        LOG.info("data :{}",JsonUtil.toJson(map));
        return JsonUtil.toJson(map);
    }



}
