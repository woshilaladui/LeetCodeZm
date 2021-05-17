package com.whut.algorithm.high_frequence.problem23_merge_k_sorted_lists;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/13 9:30
 * @desription
 */
public class MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        Queue<Integer> queue = new PriorityQueue<>();

        for (ListNode node : lists) {
            while (node != null) {
                queue.offer(node.val);
                node = node.next;
            }
        }

        //创建头结点
        ListNode head = new ListNode(0);
        ListNode tail = head;


        while (!queue.isEmpty()) {
            tail.next = new ListNode(queue.poll());
            tail = tail.next;
        }
        return head.next;
    }


    private static int add1(int a, int b) {
        //当(a&b)!=0时，表示需要进位
        while ((a & b) != 0) {
            //a 存放进位信息
            int tmp = a;
            //(a&b)<<1表示进位信息
            a = (a & b) << 1;
            //b^tmp表示非进位操作
            b ^= tmp;
        }
        //退出while循环表示a,b之间不存在进位了，通过a^b求得结果
        return a ^ b;

    }


    public static void main(String[] args) {

        System.out.println(add1(13, 5));

        System.out.println(10 ^ 0);
    }
}
