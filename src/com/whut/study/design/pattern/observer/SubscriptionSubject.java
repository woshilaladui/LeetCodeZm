package com.whut.study.design.pattern.observer;

import com.whut.algorithm.high.frequence.offer.problem_offer_64_qiu_12n_lcof.A;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/4 10:28
 * @desription
 */
public class SubscriptionSubject implements Subject {

    private List<Observer> weixinUserList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        weixinUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weixinUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : weixinUserList) {
            observer.update(message);
        }
    }
}
