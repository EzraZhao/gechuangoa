package com.ezra.gechuang.install;

import com.ezra.gechuang.domain.Privilege;
import com.ezra.gechuang.domain.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ezra on 2017/8/27.
 */
public class Installer {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static void main(String[] args) {
        System.out.println("正在执行安装...");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");

        Installer installer = (Installer) applicationContext.getBean("installer");
        installer.install();

        System.out.println("== 安装完成 ==");
    }

    @Transactional
    public void install() {
        Session session = sessionFactory.getCurrentSession();

        //添加用户
        User user = new User();
        user.setuLoginName("admin");
        user.setuName("超级管理员");
        user.setuPassword(DigestUtils.md5Hex("admin"));
        session.save(user);

        //设置权限
        Privilege menu, menu1, menu2, menu3, menu4, menu5;
        menu = new Privilege("系统管理", null, "FUNC20082.gif", null);
        menu1 = new Privilege("角色管理", "role_list", null, menu);
        menu2 = new Privilege("部门管理", "department_list", null, menu);
        menu3 = new Privilege("用户管理", "user_list", null, menu);

        session.save(menu);
        session.save(menu1);
        session.save(menu2);
        session.save(menu3);

        session.save(new Privilege("角色列表", "role_list", null, menu1));
        session.save(new Privilege("角色增加", "role_add", null, menu1));
        session.save(new Privilege("角色删除", "role_delete", null, menu1));
        session.save(new Privilege("角色修改", "role_update", null, menu1));
        session.save(new Privilege("设置权限", "role_setPrivilege", null, menu1));

        session.save(new Privilege("部门列表", "department_list", null, menu2));
        session.save(new Privilege("部门增加", "department_add", null, menu2));
        session.save(new Privilege("部门删除", "department_delete", null, menu2));
        session.save(new Privilege("部门修改", "department_update", null, menu2));

        session.save(new Privilege("用户列表", "user_list", null, menu3));
        session.save(new Privilege("用户增加", "user_add", null, menu3));
        session.save(new Privilege("用户删除", "user_delete", null, menu3));
        session.save(new Privilege("用户修改", "user_update", null, menu3));
        session.save(new Privilege("用户初始化密码", "user_initPassword", null, menu3));

        ///////////////////////////////////////////////////////////////////////////
        //网上交流
        ///////////////////////////////////////////////////////////////////////////

        menu = new Privilege("网上交流", null, "FUNC20064.gif", null);
        menu1 = new Privilege("论坛管理", "forumManager_list", null, menu);
        menu2 = new Privilege("论坛", "forum_list", null, menu);

        session.save(menu);
        session.save(menu1);
        session.save(menu2);

        ///////////////////////////////////////////////////////////////////////////
        // 审批流转
        ///////////////////////////////////////////////////////////////////////////
        menu = new Privilege("审批流转", null, "FUNC20057.gif", null);
        menu1 = new Privilege("审批流程管理", "processDefinition_list", null, menu);
        menu2 = new Privilege("申请流程管理", "applicationTemplate_list", null, menu);
        menu3 = new Privilege("起草申请", "flow_applicationTemplate", null, menu);
        menu4 = new Privilege("待我审批", "flow_myTaskList", null, menu);
        menu5 = new Privilege("我的申请查询", "flow_myApplication", null, menu);

        session.save(menu);
        session.save(menu1);
        session.save(menu2);
        session.save(menu3);
        session.save(menu4);
        session.save(menu5);
    }
}
