package com.gupao.vip.mic.webservice;

/**
 * 描述：
 * User Liu PengHao
 * Date 2018/12/28 14:05
 **/
public class Demo {
    public static void main(String[] args) {
        SayHelloImplService service = new SayHelloImplService();
        SayHelloImpl sayHello = service.getSayHelloImplPort();
        System.out.println(sayHello.sayHello("我了个去"));
    }
}
