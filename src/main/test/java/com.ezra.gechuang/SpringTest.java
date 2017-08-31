package com.ezra.gechuang;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Ezra on 2017/8/18.
 */
public class SpringTest {

    private ApplicationContext applicationContext  = new ClassPathXmlApplicationContext("spring-config.xml");

    @Test
    public void testSessionFactory() {
        SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
        System.out.println(sessionFactory + "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    @Test
    public void testTx() {
        ServiceTest userService = (ServiceTest) applicationContext.getBean("userService");
        userService.save();
    }
}
