package com.gupao.vip.michael.husky;

import java.util.List;

/**
 * <pre>
 *
 * 描述：用于配置信息---类似于注册中心
 *      🔥暂时想不出来，如何桥接，貌似也不用啊，😝
 * 此类存储的信息：
 *      1）远程服务提供者的地址，端口   用于建立socket连接
 *      2）远程服务提供者的接口信息     用于在连接基础上暴露接口
 * </pre>
 * User Liu PengHao
 * Date 2018/12/27 15:57
 **/
public class RegisterConfig {

    /**
     * 主机地址
     */
    private String host;

    /**
     * 端口
     */
    private String port;

    /**
     * 暴露出来的接口信息,demo 项目只考虑没有参数的
     */
    private List<String> openMethodInfo;
}
