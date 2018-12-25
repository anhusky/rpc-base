package com.gupao.vip.michael.socketdemo.husky;

import java.io.*;
import java.net.Socket;

/**
 * 描述：
 * User Liu PengHao
 * Date 2018/12/24 09:47
 **/
public class LPHSocketClient {

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        BufferedReader br = null;
        try {
            socket = new Socket("localhost", 8888);

            OutputStream os = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

            bw.write("hello  我是12138 客户端 \n");
            bw.flush();

            while (true) {
                // 尝试获取服务器端数据
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String clientData = br.readLine();
                if (clientData == null) {
                    break;
                }
                System.out.println("【服务端数据】" + clientData);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 判空
            br.close();
            socket.close();
        }
    }
}
