package com.gupao.vip.michael.zkclient;

import com.gupao.vip.michael.Constants;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class ZkClientApiOperatorDemo {

    private static ZkClient getInstance() {
        return new ZkClient(Constants.CONNECT_IPS, 10000);
    }

    public static void main(String[] args) throws InterruptedException {
        ZkClient zkClient = getInstance();
        //create(zkClient);
        // delete(zkClient);
        // get(zkClient);
         watch(zkClient);

    }

    private static void watch(ZkClient zkClient) throws InterruptedException {
        zkClient.subscribeDataChanges("/node", new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("节点名称：" + s + "->节点修改后的值" + o);
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {

            }
        });

        zkClient.writeData("/node", "node");
        TimeUnit.SECONDS.sleep(2);

        zkClient.subscribeChildChanges("/node", new IZkChildListener() {
            @Override
            public void handleChildChange(String s, List<String> list) throws Exception {
                System.out.println("节点名称：" + s + "->节点修改后的值" + list.toString());
            }
        });

        zkClient.createPersistent("/node/node1",true);
        TimeUnit.SECONDS.sleep(2);
    }

    /**
     * @param zkClient
     */
    private static void delete(ZkClient zkClient) {
        zkClient.deleteRecursive("/zkclient");
    }

    private static void get(ZkClient zkClient) {
        //获取子节点
        List<String> list = zkClient.getChildren("/zkclient");
        System.out.println(list);
    }

    private static void create(ZkClient zkClient) {
        //zkclient 提供递归创建父节点的功能
        zkClient.createPersistent("/zkclient/zkclient1/zkclient1-1/zkclient1-1-1", true);
        System.out.println("success");
    }
}
