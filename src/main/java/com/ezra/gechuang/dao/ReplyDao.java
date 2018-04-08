package com.ezra.gechuang.dao;

import com.ezra.gechuang.base.BaseDao;
import com.ezra.gechuang.domain.PageBean;
import com.ezra.gechuang.domain.Reply;
import com.ezra.gechuang.domain.Topic;

import java.util.List;

/**
 * Created by Ezra on 2017/9/2.
 */
public interface ReplyDao extends BaseDao<Reply> {
    List<Reply> findByTopic(Topic t);

    PageBean findPageBean(int pageNum, Topic t);
}
