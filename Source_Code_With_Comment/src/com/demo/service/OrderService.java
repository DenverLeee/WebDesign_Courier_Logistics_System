package com.demo.service;

import com.demo.vo.Order;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * Order模块的Service层（业务层）接口，提供业务方法的抽象
 */
public interface OrderService {
    /**
     * 增加订单
     *
     * @param vo
     * @return
     */
    boolean insert(Order vo);

    /**
     * 删除订单
     *
     * @param ids
     * @return
     */
    boolean delete(Collection<Serializable> ids);

    /**
     * 修改订单
     *
     * @param vo
     * @return
     */
    boolean update(Order vo);

    /**
     * 根据主键Id查询订单详情
     *
     * @param id
     * @return
     */
    Order get(Serializable id);

    /**
     * 根据条件查询订单的列表与数量
     *
     * @param params
     * @return
     */
    Map<String, Object> list(Map<String, Object> params);
}
