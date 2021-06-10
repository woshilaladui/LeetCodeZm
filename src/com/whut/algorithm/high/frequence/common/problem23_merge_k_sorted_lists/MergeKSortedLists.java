package com.whut.algorithm.high.frequence.common.problem23_merge_k_sorted_lists;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/24 16:06
 * @desription
 */
public class MergeKSortedLists {

    public static class ListNode {
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

    public static ListNode mergeKLists(ListNode[] lists) {

        Queue<Integer> queue = new PriorityQueue<>();

        for (ListNode node : lists) {
            while (node != null) {
                queue.add(node.val);
                node = node.next;
            }
        }

        ListNode head = new ListNode(0);

        ListNode tail = head;

        while (!queue.isEmpty()) {
            tail.next = new ListNode(queue.poll());
            tail = tail.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];

        ListNode node1_1 = new ListNode(1);
        ListNode node2_1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node2_2 = new ListNode(2);
        ListNode node2_3 = new ListNode(3);
        ListNode node1_4 = new ListNode(4);
        ListNode node2_4 = new ListNode(4);
        ListNode node1_5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1_1.next = node1_4;

        node1_4.next = node1_5;

        node2_1.next = node2_3;

        node2_3.next = node2_4;


        node2_2.next = node6;

        lists[0] = node1_1;
        lists[1] = node2_1;
        lists[2] = node2_2;

        ListNode head = mergeKLists(lists);

        while (head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }


    }
}
