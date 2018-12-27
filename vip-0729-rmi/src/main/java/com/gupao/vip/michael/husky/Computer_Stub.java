package com.gupao.vip.michael.husky;

import java.io.*;
import java.net.Socket;

/**
 * 描述：
 * User Liu PengHao
 * Date 2018/12/27 15:55
 **/
public class Computer_Stub extends Computer {

    @Override
    public String getBrand() {
        // TODO socket 形式获取远程 数据
        return getDataFromRemote("getBrand");
    }


    @Override
    public String getPrice() {
        return getDataFromRemote("getPrice");
    }

    private String getDataFromRemote(String methodName) {
        String brand = "";
        try {
            Socket socket = new Socket("localhost", 8888);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(methodName);
            bw.newLine();
            bw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            brand = br.readLine();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return brand;
    }
}
