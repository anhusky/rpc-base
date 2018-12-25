package com.gupao.vip.michael.parent;

import java.io.Serializable;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class User extends SuperUser implements Serializable {

    private static final long serialVersionUID = 6244837929799767391L;
    private String name;

    @Override
    public String toString() {
        return "User{} " + super.toString() + " name:" + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
