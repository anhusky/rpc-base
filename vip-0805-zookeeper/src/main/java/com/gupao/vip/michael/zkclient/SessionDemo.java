package com.gupao.vip.michael.zkclient;

import com.gupao.vip.michael.Constants;
import org.I0Itec.zkclient.ZkClient;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class SessionDemo {

    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient(Constants.CONNECT_IPS, 4000);

        System.out.println(zkClient + " - > success");
    }
}
