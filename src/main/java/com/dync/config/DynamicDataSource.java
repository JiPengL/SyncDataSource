package com.dync.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author liujipeng
 * @date 2020/6/16 16:44
 * @mail liujipeng@cloud-er.com
 * @desc ...
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DateSourceContxtLocal.getDate();
    }



}
