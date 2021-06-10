package com.whut.algorithm.high.frequence.hash.LFU;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/28 21:12
 * @desription
 */
public class LFUCache {

    //key对value的映射
    HashMap<Integer, Integer> keyToVal;

    //key对频率的映射
    HashMap<Integer, Integer> keyToFreq;

    //频率对keys的映射，key为集合
    //LinkedHashSet 可以快速删除key，时间复杂度为O(1)
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    int capacity;

    //最小访问频次
    int minFreq;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key))
            return -1;
        //找到则加频率
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (this.capacity <= 0)
            return;

        //如果已经存在,修改值，并且频率++
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }

        //如果key不存在
        //如果容量满了就要移除频次最小的key
        if (this.capacity <= keyToVal.size()) {
            removeMinFreqKey();
        }

        //插入新的结点
        //更新KV表
        keyToVal.put(key, value);

        //更新KF表
        keyToFreq.put(key, 1);

        //更新FK表
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);

        //插入新的值说明频次最小
        this.minFreq = 1;
    }

    /**
     * 删除最小频次的key，且是最久没有访问过的
     */
    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);

        int deletedKey = keyList.iterator().next();

        //更新FK表
        keyList.remove(deletedKey);
        if (keyList.isEmpty()) {
            //如果这个频次没有就移除freqToKeys中对应的该字段
            freqToKeys.remove(this.minFreq);
        }

        //更细KF表
        keyToFreq.remove(deletedKey);

        //更新KV表
        keyToVal.remove(deletedKey);
    }

    /**
     * 增加该key的访问频次
     *
     * @param key
     */
    private void increaseFreq(int key) {
        //先获取该频次
        int freq = keyToFreq.get(key);

        //更新KF表
        keyToFreq.put(key, freq + 1);

        //将其从FK表中移除
        freqToKeys.get(freq).remove(key);

        //并将key加入freq+1对应表中
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        //将key加入freq+1队列中
        freqToKeys.get(freq + 1).add(key);

        //如果freq移除后该LinkedHashSet为空，则要移除该段，并且如果该freq == minFreq时最小频率要+1
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            //如果该freq == minFreq时最小频率要+1
            if (freq == minFreq)
                this.minFreq++;
        }
    }

    public static void main(String[] args) {
    }
}
