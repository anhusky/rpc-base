package com.gupao.vip.michael.zkclient;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;

import java.io.IOException;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class MasterChooseTest {

    private final static String CONNECTSTRING = "139.199.32.78:2181";

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 3; i++) {
            int finalI = i;
            new Thread("[线程]" + finalI) {
                @Override
                public void run() {
                    ZkClient zkClient = new ZkClient(
                            CONNECTSTRING, 5000, 5000,
                            new SerializableSerializer());
                    UserCenter userCenter = new UserCenter();
                    userCenter.setMc_id(finalI);
                    userCenter.setMc_name("客户端：" + finalI);

                    MasterSelector selector = new MasterSelector(userCenter, zkClient);
                    // 触发选举操作
                    selector.start();
                }
            }.start();
        }

        /*finally {
            for (MasterSelector selector : selectorLists) {
                selector.stop();
            }
        }*/
    }
}
