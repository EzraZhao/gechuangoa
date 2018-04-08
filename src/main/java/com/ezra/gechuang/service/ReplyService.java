package com.ezra.gechuang.service;

import com.ezra.gechuang.domain.PageBean;
import com.ezra.gechuang.domain.Reply;
import com.ezra.gechuang.domain.Topic;

import java.util.List;

/**
 * Created by Ezra on 2017/9/2.
 */
public interface ReplyService {
    @Deprecated
    List<Reply> findByTopic(Topic t);

    void save(Reply reply);

    PageBean findPageBean(int i, Topic t);
}
