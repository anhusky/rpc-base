package com.gupao.vip.michael.socketdemo.husky;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 描述：
 * User Liu PengHao
 * Date 2018/12/24 09:48
 **/
public class LPHSocketServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true){
                String clientData = br.readLine();
                if(clientData == null){
                    break;
                }
                System.out.println("【服务器端收到信息】：" + clientData);

                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bw.write("Socket服务器发来贺电。。。\n");
                bw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
