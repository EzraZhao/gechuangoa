package com.ezra.gechuang.action;

import com.ezra.gechuang.domain.Forum;
import com.ezra.gechuang.domain.Topic;
import com.ezra.gechuang.service.ForumService;
import com.ezra.gechuang.service.TopicService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

/**
 * Created by Ezra on 2017/9/2.
 */
public class ForumAction extends ActionSupport implements ModelDriven<Forum> {

    private Forum forum = new Forum();

    private ForumService forumService;
    private TopicService topicService;

    @Override
    public Forum getModel() {
        return forum;
    }

    public void setForumService(ForumService forumService) {
        this.forumService = forumService;
    }

    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

    /**
     * 显示板块列表
     *
     * @return
     */
    public String list() {
        List<Forum> forums = forumService.findAll();
        ActionContext.getContext().put("forums", forums);

        return "list";
    }

    /**
     * 显示所选板块内所有主题
     *
     * @return
     */
    public String show() {
        //准备数据
        Forum f = forumService.findById(forum.getfId());
        ActionContext.getContext().put("forum", f);

        List<Topic> topics = topicService.findByForum(f);
        ActionContext.getContext().put("topics", topics);
        return "show";
    }
}
