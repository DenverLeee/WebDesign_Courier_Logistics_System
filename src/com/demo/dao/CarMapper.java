package com.demo.dao;

import com.demo.vo.Car;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * The DAO layer (data layer) interface of the Car module, 
 * providing method abstraction for database operations such as adding, deleting, changing and checking
 */
@Mapper
public interface CarMapper {
  
    int doCreate(Car vo);

    int doRemoveBatch(Collection<Serializable> ids);

    int doUpdate(Car vo);

    Car findById(Serializable id);

    List<Car> findAllSplit(Map<String, Object> params);

    Integer getAllCount(Map<String, Object> params);
}
