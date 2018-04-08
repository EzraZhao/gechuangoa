package com.ezra.gechuang.dao.impl;

import com.ezra.gechuang.base.BaseDaoImpl;
import com.ezra.gechuang.dao.ForumDao;
import com.ezra.gechuang.domain.Forum;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Ezra on 2017/8/31.
 */
@SuppressWarnings("all")
public class ForumDaoImpl extends BaseDaoImpl<Forum> implements ForumDao {

    @Override
    public List<Forum> findAll() {
        return (List<Forum>) this.getHibernateTemplate().find("from Forum order by fPosition asc ");
    }

    @Override
    public Forum findPre(Long fId) {
        Session session = this.getSessionFactory().getCurrentSession();
        Forum forum = findById(fId);
        String hql = "from Forum where fPosition < " + forum.getfPosition().toString() + " order by fPosition desc";
        Query query = session.createQuery(hql);
        query.setFirstResult(0);
        query.setMaxResults(1);
        return (Forum) query.uniqueResult();
    }

    @Override
    public Forum findNext(Long fId) {
        Session session = this.getSessionFactory().getCurrentSession();
        Forum forum = findById(fId);
        String hql = "from Forum where fPosition > " + forum.getfPosition().toString() + " order by fPosition asc";
        Query query = session.createQuery(hql);
        query.setFirstResult(0);
        query.setMaxResults(1);
        return (Forum) query.uniqueResult();
    }
}
