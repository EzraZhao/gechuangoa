package com.ezra.gechuang.interceptor;

import com.ezra.gechuang.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by Ezra on 2017/8/31.
 */
public class CheckPrivilegeInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        User user = (User) ActionContext.getContext().getSession().get("currentUser");

        String namespace = actionInvocation.getProxy().getNamespace();
        String actionName = actionInvocation.getProxy().getActionName();
        String privilegeUrl = null;

        if (namespace.endsWith("/")) {
            privilegeUrl = namespace + actionName;
        } else {
            privilegeUrl = namespace + "/" + actionName;
        }

        if (privilegeUrl.startsWith("/")) {
            privilegeUrl = privilegeUrl.substring(1);
        }

        //未登录用户
        if (user == null) {
            if (privilegeUrl.startsWith("user_login")) {
                //去登陆，放行
                return actionInvocation.invoke();
            } else {
                //如果不是去登陆，跳转到登陆界面
                return "loginUI";
            }
        }
        //如果已登录
        else {
            //判断权限，有放行，没有拦截到错误页面
            if (user.hasPrivilegeByUrl(privilegeUrl)) {
                return actionInvocation.invoke();
            } else {
                return "noPrivilegeError";
            }
        }
    }
}
