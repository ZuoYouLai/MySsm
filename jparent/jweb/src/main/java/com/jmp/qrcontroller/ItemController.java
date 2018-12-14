package com.jmp.qrcontroller;

import com.alibaba.fastjson.JSONObject;
import com.jmp.comm.Utils.Constant;
import com.jmp.comm.Utils.ResultUtils;
import com.jmp.comm.Utils.ToolUtils;
import com.jmp.jpojo.PageListDTO;
import com.jmp.redis.JedisService;
import com.jmp.service.ItemService;
import com.jmp.service.LoginService;
import com.jmp.sql.domain.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

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

    public static final String LOGIN_INDEX = "item_id";




    /**
     * method :  post
     * url :  /item
     * @author samLai
     * @date 2018/12/14 18:03
     * @params [item json]
     * @return java.lang.String
     * @Description :新增操作
     */
    @RequestMapping(produces = Constant.HTTP_PRODUCE, method = RequestMethod.POST)
    public String insert(Item item) {
        Item tk = itemService.createOneItem(item);
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
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String updateTag(Item item) {
        int size = itemService.updateOneIntem(item);
        return ResultUtils.successJSON((size == 1) ? "新增成功" : "新增失败");
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
    @RequestMapping(method = RequestMethod.GET)
    public String listTag(String name, Integer page, Integer pageSize) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageListDTO<Item> listDTO = itemService.list(name, page, pageSize);
        return ResultUtils.successJSON(listDTO, "查询成功");
    }




    /**
     * method :  post
     * url :  /item/{id}/destroy
     * @author samLai
     * @date 2018/12/14 18:28
     * @params [id]
     * @return java.lang.String
     * @throws
     * @Description :
     */
    @RequestMapping(value = "/{id}/destroy", method = RequestMethod.POST)
    public String deleteTag(@PathVariable("id") Long id) {
        int size = itemService.delOneItem(id);
        return ResultUtils.successJSON((size == 1) ? "删除成功" : "删除失败");
    }


}
