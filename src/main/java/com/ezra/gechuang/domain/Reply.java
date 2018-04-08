package com.ezra.gechuang.domain;

import java.io.Serializable;

/**
 * Created by Ezra on 2017/9/1.
 */
public class Reply extends Article implements Serializable {

    private Topic topic;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
