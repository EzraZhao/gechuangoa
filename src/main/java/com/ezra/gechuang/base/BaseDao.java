package com.ezra.gechuang.base;

import java.util.List;

/**
 * Created by Ezra on 2017/8/18.
 */
public interface BaseDao<T> {

    void save(T t);

    void delete(T t);

    void update(T t);

    T findById(Long id);

    List<T> findByIds(String idName, Long[] ids);

    List<T> findAll();

}
