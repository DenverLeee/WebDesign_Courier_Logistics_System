package com.demo.service;

import com.demo.vo.Notice;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * Service layer (business layer) interface of the Notice module, providing abstraction of business methods
 */
public interface NoticeService {

    boolean insert(Notice vo);

    boolean delete(Collection<Serializable> ids);

    boolean update(Notice vo);

    Notice get(Serializable id);

    Map<String, Object> list(Map<String, Object> params);
}
