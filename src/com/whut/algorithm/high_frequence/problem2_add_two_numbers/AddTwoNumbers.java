package com.whut.algorithm.high_frequence.problem2_add_two_numbers;

import java.util.Random;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/26 14:42
 * @desription
 */
public class AddTwoNumbers {

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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;

        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode(0);
        ListNode tail = head;

        int sum = 0;

        while (p1 != null || p2 != null){
            int numP1 = p1 != null ? p1.val : 0;
            int numP2 = p2 != null ? p2.val : 0;

            sum = numP1 + numP2 + carry;

            carry = sum/10;

            ListNode newNode = new ListNode(sum%10);

            tail.next = newNode;
            tail = newNode;

            if(p1 != null)
                p1 = p1.next;

            if(p2 != null)
                p2 = p2.next;

        }

        //判断最后一位是否有进位
        if(carry > 0)
            tail.next = new ListNode(carry);

        return head.next;
    }

    public static void main(String[] args) {
        Random random = new Random();

        int x = 100;
        int y = 200;

        int a = random.nextInt(y-x+1) + x;
    }
}
