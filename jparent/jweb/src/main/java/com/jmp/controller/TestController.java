package com.jmp.controller;

import com.jmp.comm.Utils.Constant;
import com.jmp.comm.Utils.JsonUtil;
import com.jmp.jpojo.ValidaTestBean;
import com.jmp.service.UserService;
import com.jmp.sql.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import qiniu.ip17mon.LocationInfo;
import qiniu.ip17mon.Locator;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





@RestController
@RequestMapping("/test")
@Slf4j
//@Api(tags = "测试管理")
public class TestController {


    @Autowired
    UserService userService;


    @RequestMapping(value = {"/list"}, produces = Constant.HTTP_PRODUCE)
    public String getListData() throws Exception{
        List<User> list = userService.getUserList();
        log.info("test controller.....");
        return JsonUtil.toJson(list);
    }


    //    F:\Code\GitHub\MySsm\jparent\jweb\src\main\resources\17monipdb.datx
    // test/getIp
    @RequestMapping(value = {"/getIp"}, produces = Constant.HTTP_PRODUCE)
    public String getIp(HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        log.info("path : {}", TestController.class.getResource("").toString());
        log.info("path : {}", TestController.class.getResource("/").toString());
        log.info("path : {}", TestController.class.getResource("").getPath());
        log.info("path : {}", TestController.class.getResource("/").getPath());
        Locator locator = Locator.loadFromLocal(TestController.class.getResource("/").getPath() + "17monipdb.datx");
        LocationInfo ipInfo = locator.find("180.163.159.7");
        log.info("test ip.....");
        log.info("info country : {}", ipInfo.country);
        log.info("info is : {}", ipInfo.isp);
        log.info("info city : {}", ipInfo.city);
        return ipInfo.toString();
    }



    @RequestMapping(value = {"/valid"}, produces = Constant.HTTP_PRODUCE)
    public String testParams(@RequestBody @Valid ValidaTestBean validaTestBean){
        log.info("valid bean data : {}", JsonUtil.toJson(validaTestBean));
        return "ok";
    }


    @RequestMapping(value = {"/zf"}, produces = Constant.HTTP_PRODUCE)
    public String zfTest(String name) {
        Map map = new HashMap();
        map.put("name", name);
        map.put("赖", "好哒");
        log.info("data :{}",JsonUtil.toJson(map));
        return JsonUtil.toJson(map);
    }




    @RequestMapping(value = {"/zf1"}, produces = Constant.HTTP_PRODUCE)
    public void zfTest(HttpServletResponse response) throws IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        Map map = new HashMap();
        map.put("name", "ni核实name");
        map.put("赖", "好哒");
        log.info("data :{}",JsonUtil.toJson(map));
        response.getWriter().write(JsonUtil.toJson(map));
        response.getWriter().flush();
    }



    @RequestMapping(value = {"/reqbody1"}, produces = Constant.HTTP_PRODUCE)
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
        log.info("data :{}",JsonUtil.toJson(map));
        return JsonUtil.toJson(map);
    }


//    @ApiOperation(value = "测试详情", notes = "一个测试内容详情")
//    @ApiImplicitParams({@ApiImplicitParam(name = "name", value = "测试名称", required = true, dataType = "String"),
//            @ApiImplicitParam(name = "type", value = "测试类型", required = true, dataType = "int")})
    @RequestMapping(value = {"/reqbody"}, produces = Constant.HTTP_PRODUCE)
    @ResponseBody
    public String reqbody(String name, Integer type) {
        List<Map> listMap = new ArrayList<Map>();
        Map map1 = new HashMap();
        map1.put("kk", "lop");
        listMap.add(map1);
        listMap.add(map1);
        listMap.add(map1);
        Map map = new HashMap();
        map.put("name", name);
        map.put("list", listMap);
        map.put("list2", JsonUtil.toJson(map));
        map.put("赖", "好哒");
        log.info("data :{}", JsonUtil.toJson(map));
        return JsonUtil.toJson(map);
    }



}
