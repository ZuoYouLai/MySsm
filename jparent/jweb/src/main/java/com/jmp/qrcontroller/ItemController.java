package com.jmp.qrcontroller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jmp.annotation.MyDemo;
import com.jmp.comm.Utils.Constant;
import com.jmp.comm.Utils.ResultUtils;
import com.jmp.comm.Utils.ToolUtils;
import com.jmp.jpojo.PageListDTO;
import com.jmp.redis.JedisService;
import com.jmp.service.ItemService;
import com.jmp.service.LoginService;
import com.jmp.sql.domain.Item;
import com.jmp.sql.domain.Passports;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-12-14 16:23
 * @ Description：
 */
@RestController
@RequestMapping("/item")
@Slf4j
public class ItemController {

    @Autowired
    JedisService jedisService;
    @Autowired
    private ItemService itemService;


    private Passports getOneUserId(HttpServletRequest request) {
        String token = request.getHeader("token");
        String loginKey = ToolUtils.getKey(Constant.LOGIN_INDEX, token);
        String value = jedisService.get(loginKey);
        return JSON.parseObject(value, Passports.class);
    }


    /**
     * method :  post
     * url :  /item
     * @author samLai
     * @date 2018/12/14 18:03
     * @params [item json]
     * @return java.lang.String
     * @Description :新增操作
     */
    @MyDemo
    @RequestMapping(produces = Constant.HTTP_PRODUCE, method = RequestMethod.POST)
    public String insertOrSave(HttpServletRequest request,Item item) {
        Item tk = itemService.createOneItem(item, getOneUserId(request).getId());
        return ResultUtils.successJSON(tk, "新增成功");
    }


    /**
     * method :  post
     * url :  /item/{id}
     * @author samLai
     * @date 2018/12/14 18:23
     * @params [item json]
     * @return java.lang.String
     * @throws
     * @Description :
     */
    @MyDemo
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String detail(HttpServletRequest request,@PathVariable("id") Long id) {
        Item item = itemService.detail(id, getOneUserId(request).getId());
        return ResultUtils.successJSON(item, "查询成功");
    }



    /**
     * method :  get
     * url :  /item/{id}
     * @author samLai
     * @date 2018/12/14 18:26
     * @params [name  string , page  int , pageSize  int]
     * @return java.lang.String
     * @throws
     * @Description :查询列表内容
     */
    @MyDemo
    @RequestMapping(method = RequestMethod.GET)
    public String listTag(HttpServletRequest request,String name, Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageListDTO<Item> listDTO = itemService.list(name, page, pageSize, getOneUserId(request).getId());
        return ResultUtils.successJSON(listDTO, "查询成功");
    }


    /**
     * method :  post
     * url :  /item/{id}/destroy
     *
     * @return java.lang.String
     * @throws
     * @author samLai
     * @date 2018/12/14 18:28
     * @params [id]
     * @Description :
     */
    @RequestMapping(value = "/{id}/destroy", method = RequestMethod.POST)
    public String deleteTag(@PathVariable("id") Long id, HttpServletRequest request) {
        int size = itemService.delOneItem(id, getOneUserId(request).getId());
        return ResultUtils.successJSON((size == 1) ? "删除成功" : "删除失败");
    }


}
