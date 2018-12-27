package com.gupao.vip.michael.husky;

/**
 * 描述：
 * User Liu PengHao
 * Date 2018/12/27 15:59
 **/
public class ComputerServer {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.setBrand("奔驰");
        computer.setPrice("180w");
        Computer_Skeleton computerSkeleton = new Computer_Skeleton(computer);

        computerSkeleton.start();
        System.out.println(".....服务启动....");
    }
}
