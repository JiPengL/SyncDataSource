package com.dync.entity;


import java.io.Serializable;

/**
 * @author liujipeng
 * @date 2020/11/19 14:20
 * @mail liujipeng@cloud-er.com
 * @desc ...
 */
public class User implements Serializable {
    private Integer id;

    private String name;

    private String password;

    private Integer age;

    private Integer deleteflag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Integer deleteflag) {
        this.deleteflag = deleteflag;
    }
}
