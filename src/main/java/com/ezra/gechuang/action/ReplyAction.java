package com.ezra.gechuang.action;

import com.ezra.gechuang.domain.Reply;
import com.ezra.gechuang.domain.Topic;
import com.ezra.gechuang.domain.User;
import com.ezra.gechuang.service.ReplyService;
import com.ezra.gechuang.service.TopicService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import java.util.Date;

/**
 * Created by Ezra on 2017/9/2.
 */
public class ReplyAction extends ActionSupport implements ModelDriven<Reply> {

    private Reply reply = new Reply();
    private ReplyService replyService;
    private TopicService topicService;
    private Long tId;

    @Override
    public Reply getModel() {
        return reply;
    }

    public void setReplyService(ReplyService replyService) {
        this.replyService = replyService;
    }

    public void setTopicService(TopicService topicService) {
        this.topicService = topicService;
    }

    public void settId(Long tId) {
        this.tId = tId;
    }

    public Long gettId() {
        return tId;
    }

    /**
     * 跳转到发表回复页面
     * @return
     */
    public String addUI() {
        Topic topic = topicService.findById(tId);
        ActionContext.getContext().put("topic", topic);
        return "addUI";
    }

    /**
     * 发表回复
     * 之后跳转到发表回复的对应主题界面
     * @return
     */
    public String add() {

        reply.setTopic(topicService.findById(tId));

        reply.setPostTime(new Date());
        reply.setAuthor((User) ActionContext.getContext().getSession().get("currentUser"));
        reply.setIpAdd(ServletActionContext.getRequest().getRemoteAddr());

        replyService.save(reply);
        return "toTopicShow";
    }

}
