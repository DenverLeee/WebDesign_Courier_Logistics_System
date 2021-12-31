package com.demo.service.impl;

import com.demo.dao.UserMapper;
import com.demo.service.UserService;
import com.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * A concrete implementation class of the Service layer (business layer) of the User module, 
 * providing a concrete implementation of the abstract methods defined in the UserService interface
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    //@Override
    public boolean insert(User vo) {
        return this.userMapper.doCreate(vo) == 1;
    }

    //@Override
    public boolean delete(Collection<Serializable> ids) {
        return ids.isEmpty() ? false : this.userMapper.doRemoveBatch(ids) == ids.size();
    }

    //@Override
    public boolean update(User vo) {
        return this.userMapper.doUpdate(vo) == 1;
    }

    //@Override
    public User get(Serializable id) {
        return this.userMapper.findById(id);
    }

    //@Override
    public Map<String, Object> list(Map<String, Object> params) {
        Map<String, Object> resultMap = new HashMap();
        resultMap.put("totalCount", this.userMapper.getAllCount(params));
        resultMap.put("list", this.userMapper.findAllSplit(params));
        return resultMap;
    }
}
