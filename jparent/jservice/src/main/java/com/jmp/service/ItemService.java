package com.jmp.service;

import com.alibaba.fastjson.JSONObject;
import com.jmp.jpojo.PageListDTO;
import com.jmp.sql.domain.Item;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-12-14 18:06
 * @ Description：商品的服务内容
 */
public interface ItemService {

    /**
     * 新增一个商品名称
     *
     * @param item
     * @return
     */
    Item createOneItem(Item item, Long userId);


    /**
     * 商品的详情内容
     * @param id
     * @param userId
     * @return
     */
    JSONObject detail(Long id, Long userId);


    /**
     * 更新一个商品名称
     * @param item
     * @return
     */
    int updateOneIntem(Item item, Long userId);


    /**
     * 删除一个商品
     * @param id
     * @return
     */
    int delOneItem(Long id, Long userId);


    /**
     * 商品名称 查询列表
     * @param name
     * @return
     */
    PageListDTO<JSONObject> list(String name, int page, int pageSize, Long userId);



}
