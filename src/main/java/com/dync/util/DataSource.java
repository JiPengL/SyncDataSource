package com.dync.util;

/**
 * @author liujipeng
 * @date 2020/8/11 15:37
 * @mail liujipeng@cloud-er.com
 * @desc ...
 */
public enum DataSource {

    MASTER("master"),

    SLAVE1("slave");

    private String desc;

    DataSource(String desc){
      this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}