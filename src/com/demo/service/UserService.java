package com.demo.service;

import com.demo.vo.User;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * Service layer (business layer) interface of the User module, providing abstraction of business methods
 */
public interface UserService {

    boolean insert(User vo);

    boolean delete(Collection<Serializable> ids);

    boolean update(User vo);

    User get(Serializable id);

    Map<String, Object> list(Map<String, Object> params);
}
