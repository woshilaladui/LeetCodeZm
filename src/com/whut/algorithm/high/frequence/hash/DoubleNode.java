package com.whut.algorithm.high.frequence.hash;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/28 20:00
 * @desription
 */
public class DoubleNode {

    public int key,value;
    public DoubleNode pre,next;

    public DoubleNode() {
    }

    public DoubleNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
