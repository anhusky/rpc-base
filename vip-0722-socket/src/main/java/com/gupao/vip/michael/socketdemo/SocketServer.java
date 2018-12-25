package com.gupao.vip.michael.socketdemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class SocketServer {


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            //启动一个服务
            serverSocket = new ServerSocket(8888);
           /* while (true) {*/
                //等待一个接收请求
                Socket socket = serverSocket.accept();
               /* new Thread(() -> {*/
                    try {
                        // 读取数据
                        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        // 发送数据
                        PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

                        while (true) {
                            // 读取客户端发送过来的消息
                            String clientData = reader.readLine();

                            if (clientData == null) {
                                break;
                            }

                            System.out.println("服务端接收到的数据：" + clientData);

                            writer.println("Hello Mic; ^_^");
                            writer.flush();


                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
              /*  }).start();*/
          /*  }*/

        } catch (Exception e) {

        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
