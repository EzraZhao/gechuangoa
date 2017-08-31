package com.ezra.gechuang.service;

import com.ezra.gechuang.domain.Privilege;

import java.util.List;

/**
 * Created by Ezra on 2017/8/28.
 */
public interface PrivilegeService {
    List<Privilege> findAll();

    List<Privilege> findByIds(String idName, Long[] pIds);

    List<Privilege> findTopList();

    List<String> findAllPrivilegeUrls();
}
