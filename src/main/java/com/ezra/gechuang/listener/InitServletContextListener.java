package com.ezra.gechuang.listener;

import com.ezra.gechuang.domain.Privilege;
import com.ezra.gechuang.service.PrivilegeService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * Created by Ezra on 2017/8/30.
 */
public class InitServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext application = servletContextEvent.getServletContext();

        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(application);

        PrivilegeService privilegeService = (PrivilegeService) applicationContext.getBean("privilegeServiceImpl");

        List<Privilege> topPrivileges = privilegeService.findTopList();
        application.setAttribute("topPrivileges", topPrivileges);

        System.out.println("--已准备好顶级权限数据--");

        List<String> allPrivilegeUrls = privilegeService.findAllPrivilegeUrls();
        application.setAttribute("allPrivilegeUrls", allPrivilegeUrls);
        System.out.println("--已准备好所有权限的url数据--");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
