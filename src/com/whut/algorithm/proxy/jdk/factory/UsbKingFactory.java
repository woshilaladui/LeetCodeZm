package com.whut.algorithm.proxy.jdk.factory;

import com.whut.algorithm.proxy.jdk.service.UsbService;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/11 16:07
 * @desription
 */
public class UsbKingFactory implements UsbService {
    @Override
    public double sell(int count) {
        return 85 * count;
    }

    @Override
    public double repair() {
        return 10;
    }
}
