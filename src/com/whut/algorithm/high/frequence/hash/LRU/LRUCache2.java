package com.whut.algorithm.high.frequence.hash.LRU;

import com.whut.algorithm.high.frequence.hash.DoubleList;
import com.whut.algorithm.high.frequence.hash.DoubleNode;

import java.util.HashMap;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/28 20:13
 * @desription
 */
public class LRUCache2 {

    private HashMap<Integer, DoubleNode> map;

    private DoubleList cache;

    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public LRUCache2(int capacity) {
        map = new HashMap<>();
        cache = new DoubleList();
        this.capacity = capacity;
    }

    /**
     * 将key结点标记为最近使用
     *
     * @param key
     */
    private void makeRecently(int key) {
        //先删除再重新插入
        DoubleNode x = map.get(key);

        //删除该节点
        cache.remove(x);

        //重新插入
        cache.addLast(x);
    }

    /**
     * 将新的结点加入
     *
     * @param key
     * @param value
     */
    private void addRecently(int key, int value) {
        //添加到cache中，并且添加到map中
        DoubleNode x = new DoubleNode(key, value);

        cache.addLast(x);

        map.put(key, x);
    }

    /**
     * 删除key结点
     *
     * @param key
     */
    private void removeKey(int key) {
        //删除cache,并且删除map中

        DoubleNode x = map.get(key);

        cache.remove(x);

        map.remove(key);
    }


    /**
     * 删除最久没有使用，其实就是链表最左部
     */
    private void removeLeastRecently() {

        DoubleNode x = cache.removeFirst();

        int deletedKey = x.key;

        map.remove(deletedKey);
    }

    public int get(int key) {

        //判断存不存在
        if (!map.containsKey(key))
            return -1;

        //将该结点标记为最近使用
        makeRecently(key);

        return map.get(key).value;
    }


    /**
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        //如果存在
        if(map.containsKey(key)){
            //先删除再将去插入
            removeKey(key);
            addRecently(key,value);
            return;
        }

        //满了
        if(capacity == cache.getSize()){
            //移除最久没有使用
            removeLeastRecently();

        }

        addRecently(key,value);

    }

    public static void main(String[] args) {

    }
}
