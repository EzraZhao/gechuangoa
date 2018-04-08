package com.ezra.gechuang.service;

import com.ezra.gechuang.domain.Forum;
import com.ezra.gechuang.domain.Topic;

import java.util.List;

/**
 * Created by Ezra on 2017/9/2.
 */
public interface TopicService  {
    /**
     * 根据板块查询话题列表，所有置顶帖都在上面，并按更新顺序排序
     * @param f
     * @return
     */
    List<Topic> findByForum(Forum f);

    void save(Topic topic);

    Topic findById(Long fId);
}
