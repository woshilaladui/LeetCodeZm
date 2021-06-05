package com.whut.algorithm.high.frequence.tree.problem328_odd_even_linked_list;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/5 13:20
 * @desription
 */
public class OddEvenLinkedList {


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

    public static ListNode oddEvenList(ListNode head) {
        ListNode even, odd;

        if(head == null || head.next == null || head.next.next == null)
            return head;

        //工作结点
        odd = head;
        even = odd.next;

        ListNode evenHead = even;
        while (even != null && odd != null) {

            //构造奇数结点
            odd.next = even.next;

            if (even.next == null)
                break;

            odd = even.next;

            //构造偶数结点
            even.next = odd.next;

            if (odd.next == null)
                break;
            even = odd.next;
        }

        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
       // listNode3.next = listNode4;

        ListNode temp = oddEvenList(listNode1);

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
