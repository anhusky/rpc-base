package com.gupao.mic.vip.demo;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
@Service
public class UserServiceImpl implements UserService{

    public List<User> getUsers() {
        return Storage.users;
    }

    public Response delete(int id) { //0 1
//        Storage.users.remove(id);
        Response response=new Response();
        response.setCode("00");
        response.setMsg("succes");
        return response;
    }

    public User getUser(int id) {
        return Storage.users.get(id);
    }

    public Response insert(User user) {
        return null;
    }

    public Response update(User user) {
        return null;
    }
}
