package com.demo.dao;

import com.demo.vo.User;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * The DAO layer (data layer) interface of the User module, 
 * providing method abstraction for database operations such as adding, deleting, changing and checking
 */
@Mapper
public interface UserMapper {

    int doCreate(User vo);

    int doRemoveBatch(Collection<Serializable> ids);

    int doUpdate(User vo);

    User findById(Serializable id);

    List<User> findAllSplit(Map<String, Object> params);

    Integer getAllCount(Map<String, Object> params);
}
