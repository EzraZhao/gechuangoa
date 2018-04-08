package com.ezra.gechuang.service;

import com.ezra.gechuang.domain.Forum;

import java.util.List;

/**
 * Created by Ezra on 2017/8/31.
 */
public interface ForumService {
    void save(Forum forum);

    void delete(Forum forum);

    void update(Forum forum);

    Forum findById(Long fId);

    List<Forum> findAll();

    void moveUp(Long aLong);

    void moveDown(Long aLong);
}
