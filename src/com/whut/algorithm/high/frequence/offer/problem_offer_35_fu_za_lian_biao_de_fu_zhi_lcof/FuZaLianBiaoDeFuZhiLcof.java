package com.whut.algorithm.high.frequence.offer.problem_offer_35_fu_za_lian_biao_de_fu_zhi_lcof;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/15 20:50
 * @desription
 */
public class FuZaLianBiaoDeFuZhiLcof {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList1(Node head) {
        if (head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 4. 构建新链表的 next 和 random 指向
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. 返回新链表的头节点
        return map.get(head);
//        if(head == null)
//            return null;
//
//        Map<Node,Node> map = new HashMap<>();
//
//        Node cur = head;
//
//        while (cur != null){
//            map.put(cur,new Node(cur.val));
//            cur = cur.next;
//        }
//
//        //在map中找random的位置
//        cur = head;
//
//        while (cur != null){
//            map.get(cur).next = map.get(cur.next);
//            map.get(cur).random = map.get(cur.random);
//            cur = cur.next;
//        }
//
//        return map.get(head);
    }


    public Node copyRandomList2(Node head) {
        //不使用辅助空间
        if(head == null)
            return null;

        Node cur = head;
        // 1. 复制各节点，并构建拼接链表
        while(cur != null) {
            Node temp = new Node(cur.val);

            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }

        //2. 构建的结点指向random 画图理解
        cur = head;
        while (cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        //3. 拆分链表
        Node pre = head,result = head.next;
        cur = head.next;

        while (cur.next !=  null){
            pre.next = pre.next.next;
            cur.next = cur.next.next;

            pre = pre.next;
            cur = cur.next;
        }

        //单独处理原链表最后一个结点
        pre.next = null;

        return result;
    }
    public static void main(String[] args) {

    }
}
