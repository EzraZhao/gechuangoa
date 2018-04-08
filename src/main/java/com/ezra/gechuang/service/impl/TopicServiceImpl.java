package com.ezra.gechuang.service.impl;

import com.ezra.gechuang.dao.ForumDao;
import com.ezra.gechuang.dao.TopicDao;
import com.ezra.gechuang.domain.Forum;
import com.ezra.gechuang.domain.Topic;
import com.ezra.gechuang.service.TopicService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Ezra on 2017/9/2.
 */
@Transactional
public class TopicServiceImpl implements TopicService {

    private TopicDao topicDao;
    private ForumDao forumDao;

    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    public void setForumDao(ForumDao forumDao) {
        this.forumDao = forumDao;
    }

    @Override
    public List<Topic> findByForum(Forum f) {
        return topicDao.findByForum(f);
    }

    @Override
    public void save(Topic topic) {
//        设置属性并保存
//        均为默认值，因使用包装类，需写，否则为null
        topic.setType(Topic.TYPE_NORMAL);
        topic.setLastReply(null);
        topic.setReplyCount(0);
        topic.setLastUpdateTime(new Date());
        topicDao.save(topic);
//        维护相关属性
        Forum forum = topic.getForum();
        forum.setTopicCount(forum.getTopicCount() + 1);
        forum.setArticleCount(forum.getArticleCount() + 1);
        forum.setLastTopic(topic);
        forumDao.update(forum);
    }

    @Override
    public Topic findById(Long fId) {
        return topicDao.findById(fId);
    }
}
