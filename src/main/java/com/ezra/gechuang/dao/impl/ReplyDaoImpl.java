package com.ezra.gechuang.dao.impl;

import com.ezra.gechuang.base.BaseDaoImpl;
import com.ezra.gechuang.conf.Configuration;
import com.ezra.gechuang.dao.ReplyDao;
import com.ezra.gechuang.domain.PageBean;
import com.ezra.gechuang.domain.Reply;
import com.ezra.gechuang.domain.Topic;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Ezra on 2017/9/2.
 */

@SuppressWarnings("all")
public class ReplyDaoImpl extends BaseDaoImpl<Reply> implements ReplyDao {
    @Override
    public List<Reply> findByTopic(Topic t) {
        return (List<Reply>) this.getHibernateTemplate().find("from Reply r where r.topic=? order by r.postTime asc", t);
    }

    @Override
    public PageBean findPageBean(int pageNum, Topic t) {

        int pageSize = Configuration.getPageSize();

        Session session = this.getSessionFactory().getCurrentSession();
        String hql = "from Reply r where r.topic=? order by r.postTime asc";
        Query query = session.createQuery(hql);
        query.setParameter(0, t);
        query.setFirstResult((pageNum - 1) * pageSize);
        query.setMaxResults(pageSize);
        List list = query.list();


        hql = "select count(*) from Reply r where r.topic=?";
        query = session.createQuery(hql);
        query.setParameter(0, t);
        Long recordCount = (Long) query.uniqueResult();

        return new PageBean(list, pageNum, pageSize, recordCount.intValue());
    }
}
