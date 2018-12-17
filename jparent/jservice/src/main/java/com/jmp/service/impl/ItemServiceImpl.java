package com.jmp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.jmp.comm.Utils.ToolUtils;
import com.jmp.jpojo.PageListDTO;
import com.jmp.service.ItemService;
import com.jmp.sql.domain.Item;
import com.jmp.sql.domain.ItemExample;
import com.jmp.sql.mapper.ItemMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @ Author     ：SamLai
 * @ Date       ：Created in 2018-12-14 18:12
 * @ Description：商品的添加服务
 */
@Service
@Slf4j
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Value("${project.ip}")
    private String projectIp;

    @Value("${projece.qr}")
    private String qrEndIndex;



    @Override
    public Item createOneItem(Item item, Long userId) {
        log.info("userId  :  {}", userId);
        item.setUpdatedAt(new Date());
        if (item.getId() != null) {
            List<Item> itemList = getItems(item.getId(), userId);
            if (CollectionUtils.isEmpty(itemList)) {
                throw new RuntimeException("查无此商品");
            }
            Item ik = itemList.get(0);
            item.setUpdatedAt(new Date());
            ik.setContent(item.getContent());
            itemMapper.updateByPrimaryKeyWithBLOBs(item);
        }else{
            item.setCreatedAt(new Date());
            item.setUserId(userId);
            itemMapper.insertSelective(item);
        }
        return item;
    }

    @Override
    public JSONObject detail(Long id, Long userId) {
        List<Item> itemList = getItems(id, userId);
        if (itemList.isEmpty()) {
            ToolUtils.error("查无此商品内容");
        }
        Item target = itemList.get(0);
        String qrUrl = projectIp + "/item/" + target.getId() + qrEndIndex;
        JSONObject finalObj = ToolUtils.objectToJson(target, JSONObject.class);
        finalObj.put("qrUrl", qrUrl);
        return finalObj;
    }

    private List<Item> getItems(Long id, Long userId) {
        ItemExample itemExample = new ItemExample();
        ItemExample.Criteria criteria = itemExample.createCriteria();
        criteria.andIdEqualTo(id);
        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        return itemMapper.selectByExampleWithBLOBs(itemExample);
    }


    @Override
    public int updateOneIntem(Item item, Long userId) {
        item.setUpdatedAt(new Date());
        item.setUserId(userId);
        itemMapper.updateByPrimaryKeyWithBLOBs(item);
        return 0;
    }

    @Override
    public int delOneItem(Long id, Long userId) {
        ItemExample itemExample = new ItemExample();
        itemExample.createCriteria().andUserIdEqualTo(userId).andIdEqualTo(id);
        int size = itemMapper.deleteByExample(itemExample);
        return size;
    }



    @Override
    public PageListDTO<JSONObject> list(String name, int page, int pageSize, Long userId) {
        ItemExample itemExample = new ItemExample();
        itemExample.setOrderByClause(" updated_at desc ");
        ItemExample.Criteria criteria = itemExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        if (StringUtils.isNotBlank(name)) {
            criteria.andNameLike(" %" + name + "% ");
        }
        PageHelper.startPage(page, pageSize);
        List<Item> items = itemMapper.selectByExample(itemExample);
        List<JSONObject> jsonObjectList = Lists.newArrayList();
        items.forEach(x->{
            JSONObject one = ToolUtils.objectToJson(x, JSONObject.class);
            String qrUrl = projectIp + "/item/" + x.getId() + qrEndIndex;
            one.put("qrUrl", qrUrl);
            log.info(qrUrl);
            jsonObjectList.add(one);
        });
        PageInfo pageInfo = new PageInfo(items);
        PageListDTO<JSONObject> data = new PageListDTO<>(pageInfo.isIsFirstPage(), pageInfo.isIsLastPage(), pageInfo.getPageNum(),
                pageInfo.getPageSize(), pageInfo.getPages(), pageInfo.getTotal(), pageInfo.getSize(),
                jsonObjectList);
        return data;
    }
}
