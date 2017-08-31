package com.ezra.gechuang.base;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ezra on 2017/8/18.
 */
@SuppressWarnings("all")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    private Class pClass;

    public BaseDaoImpl() {
        Class clazz = this.getClass();
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        pClass = (Class) actualTypeArguments[0];
    }

    @Override
    public void save(T t) {
        this.getHibernateTemplate().save(t);
    }

    @Override
    public void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }

    @Override
    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    @Override
    public T findById(Long id) {
        if (id == null) {
            return null;
        }
        return (T) this.getHibernateTemplate().get(pClass, id);
    }

    @Override
    public List<T> findByIds(String idName, Long[] ids) {
        if (ids == null || ids.length == 0) {
            return Collections.emptyList();
        }
        String hql = "from " + pClass.getSimpleName() + " where " + idName + " in(:ids)";

        return currentSession().createQuery(hql).setParameterList("ids", ids).list();
//        return (List<T>) this.getHibernateTemplate().find("from " + pClass.getSimpleName() + " where rId in(:ids)", ids);
    }

    @Override
    public List<T> findAll() {
        return (List<T>) this.getHibernateTemplate().find("from " + pClass.getSimpleName());
    }


}
