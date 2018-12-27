package com.gupao.vip.michael;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class HelloClient {

    public static void main(String[] args) {
        try {

            String name = "sayHello";
            Registry registry = LocateRegistry.getRegistry("localhost", 8888);

            // ISayHello hello=(ISayHello) Naming.lookup("rmi://localhost:8888/sayHello");
            ISayHello hello = (ISayHello) registry.lookup(name);
            System.out.println(hello);
            System.out.println(hello.sayHello("hello, 菲菲"));

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
