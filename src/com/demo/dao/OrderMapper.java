package com.demo.dao;

import com.demo.vo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * The DAO layer (data layer) interface of the Order module 
 * provides method abstraction for database operations such as adding, deleting, changing and checking.
 */
@Mapper
public interface OrderMapper {

    int doCreate(Order vo);

    int doRemoveBatch(Collection<Serializable> ids);

    int doUpdate(Order vo);

    Order findById(Serializable id);

    List<Order> findAllSplit(Map<String, Object> params);

    Integer getAllCount(Map<String, Object> params);
}
