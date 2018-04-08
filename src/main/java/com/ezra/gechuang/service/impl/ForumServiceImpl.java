package com.ezra.gechuang.service.impl;

import com.ezra.gechuang.dao.ForumDao;
import com.ezra.gechuang.domain.Forum;
import com.ezra.gechuang.service.ForumService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ezra on 2017/8/31.
 */
@Transactional
public class ForumServiceImpl implements ForumService {

    private ForumDao forumDao;

    public void setForumDao(ForumDao forumDao) {
        this.forumDao = forumDao;
    }

    @Override
    public void save(Forum forum) {
        //指定position值为最大值
        forumDao.save(forum);
        //因为是持久化对象，所以不必调用update
        forum.setfPosition(forum.getfId().intValue());
    }

    @Override
    public void delete(Forum forum) {
        forumDao.delete(forum);
    }

    @Override
    public void update(Forum forum) {
        forumDao.update(forum);
    }

    @Override
    public Forum findById(Long fId) {
        return forumDao.findById(fId);
    }

    @Override
    public List<Forum> findAll() {
        return forumDao.findAll();
    }

    @Override
    public void moveUp(Long fId) {
        Forum forum = findById(fId);
        Forum other = forumDao.findPre(fId);

        if (other == null) {
            return;
        }

        int temp = forum.getfPosition();
        forum.setfPosition(other.getfPosition());
        other.setfPosition(temp);
    }

    @Override
    public void moveDown(Long fId) {
        Forum forum = findById(fId);
        Forum other = forumDao.findNext(fId);

        if (other == null) {
            return;
        }

        int temp = forum.getfPosition();
        forum.setfPosition(other.getfPosition());
        other.setfPosition(temp);
    }
}
