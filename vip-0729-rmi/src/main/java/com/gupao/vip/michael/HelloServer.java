package com.gupao.vip.michael;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class HelloServer {

    public static void main(String[] args) {
        try {
            ISayHello hello = new SayHelloImpl();

            Registry registry = LocateRegistry.createRegistry(8888);
            registry.bind("sayHello", hello);

           // Naming.bind("rmi://localhost:8888/sayHello", hello);
            System.out.println("server start success");

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
