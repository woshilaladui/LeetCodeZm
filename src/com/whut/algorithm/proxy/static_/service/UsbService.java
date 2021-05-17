package com.whut.algorithm.proxy.static_.service;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/11 16:08
 * @desription
 */
public interface UsbService {
    /**
     * 定义一个方法 参数 amount:表示一次购买的数量,暂时不用
     * 返回值表示一个u盘的价格
     * @param count
     * @return
     */
    double sell(int count);
}
