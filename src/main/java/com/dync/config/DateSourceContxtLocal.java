package com.dync.config;

/**
 * @author liujipeng
 * @date 2020/6/16 16:42
 * @mail liujipeng@cloud-er.com
 * @desc ...
 */
public class DateSourceContxtLocal {

    private static ThreadLocal<String> datasource = new ThreadLocal<>();

    public static String getDate(){
        return datasource.get();
    }

    public static void setDate(String data){
        datasource.set(data);
    }

    public static void clean(){
        datasource.remove();
    }

}
