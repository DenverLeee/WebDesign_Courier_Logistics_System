package com.demo.service;

import com.demo.vo.Car;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * Service layer (business layer) interface of the Car module, providing abstraction of business methods
 */
public interface CarService {
 
    boolean insert(Car vo);

    boolean delete(Collection<Serializable> ids);

    boolean update(Car vo);

    Car get(Serializable id);

    Map<String, Object> list(Map<String, Object> params);
}
