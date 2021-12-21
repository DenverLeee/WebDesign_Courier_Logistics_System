package com.demo.dao;

import com.demo.vo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Order模块的DAO层（数据层）接口，提供增删改查等数据库操作的方法抽象
 */
@Mapper
public interface OrderMapper {
    /**
     * 增加订单表记录
     *
     * @param vo
     * @return
     */
    int doCreate(Order vo);

    /**
     * 根据主键id的集合，批量删除对应的订单表记录
     *
     * @param ids
     * @return
     */
    int doRemoveBatch(Collection<Serializable> ids);

    /**
     * 更新订单表记录
     *
     * @param vo
     * @return
     */
    int doUpdate(Order vo);

    /**
     * 根据主键id获取订单表记录的详情
     *
     * @param id
     * @return
     */
    Order findById(Serializable id);

    /**
     * 根据条件查询订单表集合
     *
     * @param params
     * @return
     */
    List<Order> findAllSplit(Map<String, Object> params);

    /**
     * 根据条件查询订单数量
     *
     * @param params
     * @return
     */
    Integer getAllCount(Map<String, Object> params);
}
