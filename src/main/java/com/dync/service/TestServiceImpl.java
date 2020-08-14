package com.dync.service;

import com.dync.annotion.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author liujipeng
 * @date 2020/8/11 14:42
 * @mail liujipeng@cloud-er.com
 * @desc ...
 */
@Service
public class TestServiceImpl{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Master
    public Object getUserinfo(){
        String sql = "select * from user";
        jdbcTemplate.query(sql,
                new ResultSetExtractor<Object>() {
            @Override
            public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("id"));
                    System.out.println(resultSet.getString("name"));
                }
                return null;
            }
        });

        return "";
    }

    public Object getUser(){
        String sql = "select * from user";
        jdbcTemplate.query(sql,
                new ResultSetExtractor<Object>() {
                    @Override
                    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                        while (resultSet.next()) {
                            System.out.println(resultSet.getInt("id"));
                            System.out.println(resultSet.getString("name"));
                        }
                        return null;
                    }
                });

        return "";
    }



}
