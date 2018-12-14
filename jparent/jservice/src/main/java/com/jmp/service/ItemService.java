package com.jmp.service;

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
     * @param item
     * @return
     */
    Item createOneItem(Item item);


    /**
     * 更新一个商品名称
     * @param item
     * @return
     */
    int updateOneIntem(Item item);


    /**
     * 删除一个商品
     * @param id
     * @return
     */
    int delOneItem(Long id);


    /**
     * 商品名称 查询列表
     * @param name
     * @return
     */
    PageListDTO<Item> list(String name, int page, int pageSize);



}
