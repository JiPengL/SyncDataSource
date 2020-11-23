package com.dync.controller;

import com.dync.service.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liujipeng
 * @date 2020/6/16 17:13
 * @mail liujipeng@cloud-er.com
 * @desc ...
 */
@RestController
@RequestMapping("/v")
public class Test {

    @Autowired
    private TestServiceImpl testService;

    @RequestMapping("/masterDb")
    private String master(){
        testService.getUserinfo();
        return "success";
    }

    @RequestMapping("/slaveDb")
    private String slave(){
        testService.getUser();
        return "success";
    }

    /*test mybitas*/
/*
    @Autowired
    private TestMybatis testMybatis;

    @RequestMapping("/masterDb")
    private String mybitasMaster(){
        Object userinfo = testMybatis.getUserinfo();
        System.out.println(JSONObject.toJSONString(userinfo));
        return "success";
    }

    @RequestMapping("/slaveDb")
    private String mybitasSlave(){
        testMybatis.save();
        return "success";
    }*/
}
