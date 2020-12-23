package com.whut.algorithm.modifying_array_in_place.problem83_remove_duplicates_from_sorted_list;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/14 16:14
 * @desription
 */
public class RemoveDuplicatesFromSortedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private ListNode deleteDuplicates(ListNode head) {

        if (head == null) return null;
        ListNode slow = head, fast = head;

        while (fast != null){

            if(slow.val != fast.val){
                //画图
                //将重复元素序列丢弃
                slow.next = fast;

                slow = slow.next;
            }
            fast = fast.next;

        }

        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {

    }

}
