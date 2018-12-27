package com.gupao.vip.michael.husky;

import java.io.IOException;

/**
 * 描述：
 * User Liu PengHao
 * Date 2018/12/27 15:58
 **/
public class ComputerClient {
    public static void main(String[] args) throws IOException {
        Computer computer = new Computer_Stub();
        System.out.println("品牌:" + computer.getBrand());
        System.out.println("价格:" + computer.getPrice());
    }
}
