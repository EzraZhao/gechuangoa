package com.ezra.gechuang.conf;

/**
 * Created by Ezra on 2017/9/3.
 */
public class Configuration {

    private static int pageSize;

    static {
        //读取default.properties配置文件，初始化所有配置
        pageSize = 10;
    }

    public static int getPageSize() {
        return pageSize;
    }

}
