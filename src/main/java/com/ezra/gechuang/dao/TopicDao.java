package com.ezra.gechuang.dao;

import com.ezra.gechuang.base.BaseDao;
import com.ezra.gechuang.domain.Forum;
import com.ezra.gechuang.domain.Topic;

import java.util.List;

/**
 * Created by Ezra on 2017/9/2.
 */
public interface TopicDao extends BaseDao<Topic> {
    List<Topic> findByForum(Forum f);
}
