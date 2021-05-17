package com.whut.algorithm.proxy.static_.factory;

import com.whut.algorithm.proxy.static_.service.UsbService;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/11 16:07
 * @desription
 */
//目标类:金士顿厂家,不接受用户的单独购买
public class UsbKingFactory implements UsbService {
    @Override
    public double sell(int count) {

        return 85 * count;
    }
}
