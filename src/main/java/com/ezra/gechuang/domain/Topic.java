package com.ezra.gechuang.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ezra on 2017/9/1.
 */
public class Topic extends Article implements Serializable {

    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_BAST = 1;
    public static final int TYPE_TOP = 2;

    private Forum forum;
    private Set<Reply> replys = new HashSet<>();

    private Integer type;
    private Date lastUpdateTime;
    private Integer replyCount;
    private Reply lastReply;

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public Set<Reply> getReplys() {
        return replys;
    }

    public void setReplys(Set<Reply> replys) {
        this.replys = replys;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Reply getLastReply() {
        return lastReply;
    }

    public void setLastReply(Reply lastReply) {
        this.lastReply = lastReply;
    }
}
