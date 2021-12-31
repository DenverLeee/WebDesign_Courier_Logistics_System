package com.demo.service;

import com.demo.vo.Order;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * Service layer (business layer) interface of the Order module, providing abstraction of business methods
 */
public interface OrderService {

    boolean insert(Order vo);

    boolean delete(Collection<Serializable> ids);

    boolean update(Order vo);

    Order get(Serializable id);

    Map<String, Object> list(Map<String, Object> params);
}
