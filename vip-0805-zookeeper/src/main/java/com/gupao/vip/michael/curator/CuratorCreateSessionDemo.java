package com.gupao.vip.michael.curator;

import com.gupao.vip.michael.Constants;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class CuratorCreateSessionDemo {

    public static void main(String[] args) {
        //创建会话的两种方式 normal
        CuratorFramework curatorFramework = CuratorFrameworkFactory.
                newClient(Constants.CONNECT_IPS, 5000, 5000,
                        new ExponentialBackoffRetry(1000, 3));
        curatorFramework.start(); //start方法启动连接

        //fluent风格
        CuratorFramework curatorFramework1 = CuratorFrameworkFactory.builder()
                .connectString(Constants.CONNECT_IPS).sessionTimeoutMs(5000).
                retryPolicy(new ExponentialBackoffRetry(1000, 3)).
                namespace("/curator").build();

        curatorFramework1.start();
        System.out.println("success");
    }
}
