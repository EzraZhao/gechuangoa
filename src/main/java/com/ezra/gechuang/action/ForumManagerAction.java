package com.ezra.gechuang.action;

import com.ezra.gechuang.domain.Forum;
import com.ezra.gechuang.service.ForumService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

/**
 * Created by Ezra on 2017/8/31.
 */
public class ForumManagerAction extends ActionSupport implements ModelDriven<Forum> {

    private Forum forum = new Forum();
    private ForumService forumService;

    @Override
    public Forum getModel() {
        return forum;
    }

    public void setForumService(ForumService forumService) {
        this.forumService = forumService;
    }

    public String addUI() {
        return "toEditPage";
    }

    public String add() {
        forumService.save(forum);
        return "toList";
    }

    public String delete() {
        Forum f = forumService.findById(forum.getfId());
        forumService.delete(f);
        return "toList";
    }

    public String updateUI() {
        Forum f = forumService.findById(forum.getfId());
        ActionContext.getContext().getValueStack().push(f);
        return "toEditPage";
    }

    public String update() {
        Forum f = forumService.findById(forum.getfId());

        f.setfName(forum.getfName());
        f.setfDescription(forum.getfDescription());

        forumService.update(f);
        return "toList";
    }

    public String list() {
        List<Forum> forums = forumService.findAll();
        ActionContext.getContext().put("forums", forums);
        return "list";
    }

    public String moveUp() {
        forumService.moveUp(forum.getfId());
        return "toList";
    }

    public String moveDown() {
        forumService.moveDown(forum.getfId());
        return "toList";
    }
}
