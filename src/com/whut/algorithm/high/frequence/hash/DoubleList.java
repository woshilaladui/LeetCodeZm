package com.whut.algorithm.high.frequence.hash;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/28 20:02
 * @desription
 */
public class DoubleList {

    private DoubleNode head,tail;

    private int size;

    public DoubleList() {
        head = new DoubleNode(0,0);
        tail = new DoubleNode(0,0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public void addLast(DoubleNode x){

        x.pre = tail.pre;
        x.next = tail;

        tail.pre.next = x;
        tail.pre = x;

        size++;
    }

    public void remove(DoubleNode x){
        x.pre.next = x.next;
        x.next.pre = x.pre;
        size--;
    }

    /**
     * 删除第一个结点
     * @return
     */
    public DoubleNode removeFirst(){
        if(head.next == tail)
            return null;

        DoubleNode first = head.next;
        remove(first);
        return first;
    }

    public int getSize() {
        return size;
    }
}
