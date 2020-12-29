package com.whut.hash.LRU;

import java.util.LinkedHashMap;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/28 17:13
 * @desription
 */
public class LRUCache {


    public int capacity;

    //双向循环链表，每次插入再最前面插入
    private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;

        //将key变为最近使用过
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        //如果存在
        if (cache.containsKey(key)) {
            //修改值再将其提高成最近使用
            cache.put(key, value);

            makeRecently(key);
            return;
        }

        if (cache.size() >= capacity) {
            //删除最近没有使用的，链表头部就是没有使用过的
            int oldKey = cache.keySet().iterator().next();
            cache.remove(oldKey);
        }

        //将新的结点加入进来
        cache.put(key,value);


    }

    public void makeRecently(int key) {
        //删除再删除
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }

    public static void main(String[] args) {

    }
}
