package com.whut.algorithm.high_frequence.problem142_linked_list_cycle_ii;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/14 15:01
 * @desription
 */
public class LinkedListCycleII {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle1(ListNode head) {

        ListNode pos = head;

        Set<ListNode> visited = new HashSet<>();

        while (pos != null) {
            if (visited.contains(pos))
                return pos;
            else {
                visited.add(pos);
                pos = pos.next;
            }
        }
        return null;
    }

    public static ListNode detectCycle2(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;


    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(22);
        listNode.next = listNode2;

        ListNode result = detectCycle2(listNode);

        System.out.println(result.val);
    }
}
