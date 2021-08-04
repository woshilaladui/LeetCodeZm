package com.whut.study.design.pattern.observer;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/4 10:25
 * @desription
 */
public interface Subject {
    /**
     * 增加订阅者
     * @param observer
     */
    void attach(Observer observer);

    /**
     * 移除订阅者
     * @param observer
     */
    void detach(Observer observer);

    /**
     * 通知订阅者更新
     * @param message
     */
    void notify(String message);
}
