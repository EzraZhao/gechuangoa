package com.ezra.gechuang;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by Ezra on 2017/8/18.
 */
@Controller
@Scope("prototype")
public class ActionTest extends ActionSupport {
    @Override
    public String execute() throws Exception {
        System.out.println("execute"+"-------------");
        return "success";
    }
}
