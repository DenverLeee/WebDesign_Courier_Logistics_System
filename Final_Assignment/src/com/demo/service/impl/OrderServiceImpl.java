package com.demo.service.impl;

import com.demo.dao.OrderMapper;
import com.demo.service.OrderService;
import com.demo.vo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Order模块的Service层（业务层）的具体实现类，对OrderService接口中定义的抽象方法作出具体的功能实现
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;


    //@Override
    public boolean insert(Order vo) {
        return this.orderMapper.doCreate(vo) == 1;
    }

    //@Override
    public boolean delete(Collection<Serializable> ids) {
        return ids.isEmpty() ? false : this.orderMapper.doRemoveBatch(ids) == ids.size();
    }

    //@Override
    public boolean update(Order vo) {
        return this.orderMapper.doUpdate(vo) == 1;
    }

    //@Override
    public Order get(Serializable id) {
        return this.orderMapper.findById(id);
    }

    //@Override
    public Map<String, Object> list(Map<String, Object> params) {
        Map<String, Object> resultMap = new HashMap();
        resultMap.put("totalCount", this.orderMapper.getAllCount(params));
        resultMap.put("list", this.orderMapper.findAllSplit(params));
        return resultMap;
    }
}
