package com.whut.algorithm.high.frequence.common.problem82_remove_duplicates_from_sorted_list_ii;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/11 18:48
 * @desription
 */
public class RemoveDuplicatesFromSortedListII {

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

    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode pre = new ListNode(-999, head);

        ListNode cur = pre;

        while (cur.next != null && cur.next.next != null) {

            //跳过重复结点
            if(cur.next.val == cur.next.next.val){
                //记录重复结点
                int x = cur.next.val;
                //跳过重复结点
                while (cur.next != null && cur.next.val == x){
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }

        return pre.next;

    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3_1 = new ListNode(3);
        ListNode listNode3_2 = new ListNode(3);
        ListNode listNode4_1 = new ListNode(4);
        ListNode listNode4_2 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;

        listNode2.next = listNode3_1;
        listNode3_1.next = listNode3_2;

        listNode3_2.next = listNode4_1;
        listNode4_1.next = listNode4_2;
        listNode4_2.next = listNode5;

        deleteDuplicates(listNode1);

        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}
