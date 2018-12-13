package com.jmp.controller;

import com.alibaba.fastjson.JSONObject;
import com.japi.service.BaseService;
import com.jmp.comm.Utils.Constant;
import com.jmp.comm.Utils.JsonUtil;
import com.jmp.comm.Utils.ResultUtils;
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
@RequestMapping("/dubbo")
@Slf4j
public class dubboController {

    @Autowired
    BaseService baseService;

    @RequestMapping(value = {"/test"}, produces = Constant.HTTP_PRODUCE)
    public String getListData(Long userId) {
        JSONObject jsonObject = baseService.doOneUserGroup(userId);
        return ResultUtils.successJSON(jsonObject);
    }


}
