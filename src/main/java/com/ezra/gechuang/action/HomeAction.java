package com.ezra.gechuang.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Ezra on 2017/8/29.
 */
public class HomeAction extends ActionSupport {

    public String index() {

        return "index";
    }

    public String top() {

        return "top";
    }

    public String bottom() {

        return "bottom";
    }

    public String left() {

        return "left";
    }

    public String right() {

        return "right";
    }


}
