package com.ezra.gechuang.dao;

import com.ezra.gechuang.base.BaseDao;
import com.ezra.gechuang.domain.Forum;

/**
 * Created by Ezra on 2017/8/31.
 */
public interface ForumDao extends BaseDao<Forum> {
    Forum findPre(Long fId);

    Forum findNext(Long fId);
}
