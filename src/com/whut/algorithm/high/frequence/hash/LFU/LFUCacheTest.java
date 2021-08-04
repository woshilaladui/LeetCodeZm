package com.whut.algorithm.high.frequence.hash.LFU;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/4 19:39
 * @desription
 */
public class LFUCacheTest {

    private int minFreq;

    private int capacity;

    private HashMap<Integer, Integer> keyToVal;

    private HashMap<Integer, Integer> keyToFreq;

    private HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUCacheTest(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
    }

    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);

        //第一个节点是最先加入的节点
        int deleteKey = keyList.iterator().next();


        /**
         * 更新KV表
         */
        keyToVal.remove(deleteKey);

        /**
         * 更新KF表
         */
        keyToFreq.remove(deleteKey);

        /**
         * 删除FKS 表
         */
        keyList.remove(deleteKey);
        if (keyList.isEmpty()) {
            //如果这个频次没有就移除freqToKeys中对应的该字段
            freqToKeys.remove(this.minFreq);
        }
    }

    private void increaseKeyFreq(int key) {
        //获取频率
        int freq = keyToFreq.get(key);

        //将频率++
        keyToFreq.put(key, freq + 1);

        /**
         * 更新FKS表
         */
        //将原来的freqToKeys 对应的 freq值删掉
        freqToKeys.get(freq).remove(key);
        //如果删除后没有节点则删除该链表 如果这个频次没有就移除freqToKeys中对应的该字段
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);

            //如果该freq == minFreq时最小频率要+1
            if (freq == minFreq)
                this.minFreq++;
        }

        //将该节点频次加1
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key))
            return -1;

        //找到则加频率
        increaseKeyFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (this.capacity <= 0)
            return;

        //如果包含了这个key,直接增加其频率
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseKeyFreq(key);
            return;
        }

        //不包含
        //1. 先判断容量是否瞒了
        //如果key不存在
        //如果容量满了就要移除频次最小的key
        if (keyToVal.size() >= this.capacity) {
            removeMinFreqKey();
        }

        /**
         * 2. 插入节点，并更新KV表
         */
        keyToVal.put(key, value);

        /**
         * 3. 更新 KF 表
         */
        keyToFreq.put(key, 1);

        /**
         * 4. 更新 FKS 表
         */
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);

        /**
         * 5. 更新当前最小频率
         */
        this.minFreq = 1;

    }
}
