package com.ezra.gechuang;

import com.ezra.gechuang.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Ezra on 2017/8/18.
 */
@Service
public class ServiceTest {
    @Resource
    private SessionFactory sessionFactory;

    @Transactional
    public void save() {
        Session session = sessionFactory.getCurrentSession();
        session.save(new User());
        session.save(new User());
    }
}
