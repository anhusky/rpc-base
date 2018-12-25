package com.gupao.vip.michael.socketdemo;

import java.io.*;
import java.net.Socket;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class SocketClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);

            // 读取服务端信息
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 往服务端写数据
           // PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write("Hello 菲菲 \n");
            writer.flush();
            while (true) {
                String serverData = reader.readLine();

                if (serverData == null) {
                    break;
                }
                System.out.println("客户端收到数据：" + serverData);
            }
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
