package com.gupao.vip.michael.husky;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 描述：
 * User Liu PengHao
 * Date 2018/12/27 15:55
 **/
public class Computer_Skeleton extends Thread {

    private Computer computer;

    public Computer_Skeleton(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            while (true) {
                Socket socket = serverSocket.accept();
                if (socket != null) {
                    InputStream inputStream = socket.getInputStream();
                    if (inputStream == null) {
                        continue;
                    }
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String methodName = br.readLine();

                    String outData = "";
                    if (methodName != null) {
                        if ("getBrand".equals(methodName)) {
                            outData = computer.getBrand();
                        }
                        if ("getPrice".equals(methodName)) {
                            outData = computer.getPrice();
                        }
                    }

                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    bw.write(outData);
                    bw.newLine();
                    bw.flush();
                    bw.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
