package com.demo.dao;

import com.demo.vo.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * DAO layer (data layer) interface of the Notice module, 
 * providing method abstraction for database operations such as adding, deleting, changing and checking
 */
@Mapper
public interface NoticeMapper {

    int doCreate(Notice vo);

    int doRemoveBatch(Collection<Serializable> ids);

    int doUpdate(Notice vo);

    Notice findById(Serializable id);

    List<Notice> findAllSplit(Map<String, Object> params);

    Integer getAllCount(Map<String, Object> params);
}
