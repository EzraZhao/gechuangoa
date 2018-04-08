package com.ezra.gechuang.dao.impl;

import com.ezra.gechuang.base.BaseDaoImpl;
import com.ezra.gechuang.dao.TopicDao;
import com.ezra.gechuang.domain.Forum;
import com.ezra.gechuang.domain.Topic;

import java.util.List;

/**
 * Created by Ezra on 2017/9/2.
 */
@SuppressWarnings("all")
public class TopicDaoImpl extends BaseDaoImpl<Topic> implements TopicDao {

    @Override
    public List<Topic> findByForum(Forum f) {
        return (List<Topic>) this.getHibernateTemplate()
                .find("from Topic t where t.forum=? order by (case t.type when 2 then 2 else 0 end) desc, t.lastUpdateTime desc", f);
    }
}
