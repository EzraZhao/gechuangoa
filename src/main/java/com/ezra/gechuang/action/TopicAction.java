package com.ezra.gechuang.action;

import com.ezra.gechuang.domain.*;
import com.ezra.gechuang.service.ForumService;
import com.ezra.gechuang.service.ReplyService;
import com.ezra.gechuang.service.TopicService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import java.util.Date;
import java.util.List;

/**
 * Created by Ezra on 2017/9/2.
 */
public class TopicAction extends ActionSupport implements ModelDriven<Topic> {

    private Topic topic = new Topic();
    private TopicService topicService;
    private ForumService forumService;
    private ReplyService replyService;

    private Long fId;
    private int pageNum = 1;

    @Override
    public Topic getModel() {
        return topic;
    }

    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

    public void setForumService(ForumService forumService) {
        this.forumService = forumService;
    }

    public void setReplyService(ReplyService replyService) {
        this.replyService = replyService;
    }

    public Long getfId() {
        return fId;
    }

    public void setfId(Long fId) {
        this.fId = fId;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * 显示单个主题
     * @return
     */
    public String show() {
        //准备数据topic
        Topic t = topicService.findById(topic.getId());
        ActionContext.getContext().put("topic", t);
//        //准备回复列表replies
//        List<Reply> replies = replyService.findByTopic(t);
//        ActionContext.getContext().put("replies", replies);
        //准备分页的回复列表
        PageBean pageBean = replyService.findPageBean(1, t);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "show";
    }

    /**
     * 跳转到发表新主题页面
     * @return
     */
    public String addUI() {
        Forum f = forumService.findById(fId);
        ActionContext.getContext().put("forum", f);
        return "addUI";
    }

    /**
     * 发表新主题
     * 之后跳转到新发表的主题页面
     * @return
     */
    public String add() {
        //封装
        //表单中的字段

        topic.setForum(forumService.findById(fId));
        //当前可以直接获取的信息
        topic.setAuthor((User) ActionContext.getContext().getSession().get("currentUser"));
        topic.setPostTime(new Date());
        topic.setIpAdd(ServletActionContext.getRequest().getRemoteAddr());
        //应放到业务方法中的信息
//        topic.setType();
//        topic.setLastReply();
//        topic.setReplyCount();
//        topic.setLastUpdateTime(new Date());
        topicService.save(topic);

        return "toShow";
    }
}
