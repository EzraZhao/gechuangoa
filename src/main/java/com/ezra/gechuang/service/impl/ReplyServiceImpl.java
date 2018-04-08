package com.ezra.gechuang.service.impl;

import com.ezra.gechuang.dao.ForumDao;
import com.ezra.gechuang.dao.ReplyDao;
import com.ezra.gechuang.dao.TopicDao;
import com.ezra.gechuang.domain.Forum;
import com.ezra.gechuang.domain.PageBean;
import com.ezra.gechuang.domain.Reply;
import com.ezra.gechuang.domain.Topic;
import com.ezra.gechuang.service.ReplyService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ezra on 2017/9/2.
 */
@Transactional
public class ReplyServiceImpl implements ReplyService {

    private ReplyDao replyDao;
    private ForumDao forumDao;
    private TopicDao topicDao;

    public void setReplyDao(ReplyDao replyDao) {
        this.replyDao = replyDao;
    }

    public void setForumDao(ForumDao forumDao) {
        this.forumDao = forumDao;
    }

    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    @Override
    public List<Reply> findByTopic(Topic t) {
        return replyDao.findByTopic(t);
    }

    @Override
    public void save(Reply reply) {
        replyDao.save(reply);

        //维护相关信息
        Topic topic = reply.getTopic();

        Forum forum = topic.getForum();
        forum.setArticleCount(forum.getArticleCount() + 1);

        topic.setReplyCount(topic.getReplyCount() + 1);
        topic.setLastReply(reply);
        topic.setLastUpdateTime(reply.getPostTime());

        topicDao.update(topic);
        forumDao.update(forum);
    }

    @Override
    public PageBean findPageBean(int pageNum, Topic t) {
        return replyDao.findPageBean(pageNum, t);
    }
}
