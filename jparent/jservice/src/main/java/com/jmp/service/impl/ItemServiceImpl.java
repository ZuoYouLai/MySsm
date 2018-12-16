package com.jmp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmp.comm.Utils.ToolUtils;
import com.jmp.jpojo.PageListDTO;
import com.jmp.service.ItemService;
import com.jmp.sql.domain.Item;
import com.jmp.sql.domain.ItemExample;
import com.jmp.sql.mapper.ItemMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public Item createOneItem(Item item, Long userId) {
        item.setUpdatedAt(new Date());
        if (item.getId() != null) {
            itemMapper.updateByPrimaryKeyWithBLOBs(item);
        }else{
            item.setCreatedAt(new Date());
            item.setUserId(userId);
            itemMapper.insertSelective(item);
        }
        return item;
    }

    @Override
    public Item detail(Long id, Long userId) {
        ItemExample itemExample = new ItemExample();
        ItemExample.Criteria criteria = itemExample.createCriteria();
        criteria.andIdEqualTo(id);
        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        List<Item> itemList = itemMapper.selectByExample(itemExample);
        if (itemList.isEmpty()) {
            ToolUtils.error("查无此商品内容");
        }
        return itemList.get(0);
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
    public PageListDTO<Item> list(String name, int page, int pageSize, Long userId) {
        ItemExample itemExample = new ItemExample();
        ItemExample.Criteria criteria = itemExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        if (StringUtils.isNotBlank(name)) {
            criteria.andNameLike(" %" + name + "% ");
        }
        PageHelper.startPage(page, pageSize);
        List<Item> items = itemMapper.selectByExampleWithBLOBs(itemExample);
        PageInfo pageInfo = new PageInfo(items);
        PageListDTO<Item> data = new PageListDTO<>(pageInfo.isIsFirstPage(), pageInfo.isIsLastPage(), pageInfo.getPageNum(),
                pageInfo.getPageSize(), pageInfo.getPages(), pageInfo.getTotal(), pageInfo.getSize(),
                items);
        return data;
    }
}
