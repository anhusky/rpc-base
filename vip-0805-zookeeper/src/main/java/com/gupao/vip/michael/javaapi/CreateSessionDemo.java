package com.gupao.vip.michael.javaapi;

import com.gupao.vip.michael.Constants;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class CreateSessionDemo {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    static ZooKeeper zooKeeper = null;
    static Stat stat = new Stat();

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        zooKeeper = new ZooKeeper(Constants.CONNECT_IPS, 5000, new StatusWatcher());
        countDownLatch.await();
        System.out.println("zookeeper连接状态---->" + zooKeeper.getState());

        String result = zooKeeper.create("/root/oneCar", "oneCar".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zooKeeper.getData("/root/oneCar", true, stat);

        System.out.println("创建成功-----> " + result);
        zooKeeper.setData("/root/oneCar", "123".getBytes(), -1);

        TimeUnit.SECONDS.sleep(3);
        // create();
    }

    /**
     * zookeeper 状态监听
     */
    static class StatusWatcher implements Watcher {
        @Override
        public void process(WatchedEvent event) {
            // 如果当前的连接状态是连接成功的，那么通过计数器去控制
            if (event.getState() == Event.KeeperState.SyncConnected) {
                try {
                    byte[] data = zooKeeper.getData("/root", true, stat);
                    String path = event.getPath();
                    System.out.println("【路径】：" + path + "||【数据】" + data.toString());

                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                switch (event.getType()) {
                    case NodeDataChanged:

                        System.out.println();
                        System.out.println(">-------NodeDataChanged");
                        break;
                    case None:
                        System.out.println(">-------None");
                        break;
                    case NodeDeleted:
                        System.out.println(">-------NodeDeleted");
                        break;
                    case NodeCreated:
                        System.out.println(">-------NodeCreated");
                        break;
                    case NodeChildrenChanged:
                        System.out.println(">-------NodeChildrenChanged");
                        break;
                }
            }
            countDownLatch.countDown();
        }
    }


}
