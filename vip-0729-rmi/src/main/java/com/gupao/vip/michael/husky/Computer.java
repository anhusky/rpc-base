package com.gupao.vip.michael.husky;

import java.io.IOException;

/**
 * 描述：
 * User Liu PengHao
 * Date 2018/12/27 15:54
 **/
public class Computer {

    /**
     * 品牌
     */
    private String brand;

    /**
     * 价格
     */
    private String price;

    public String getBrand() throws IOException {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
