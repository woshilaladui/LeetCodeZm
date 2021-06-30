package com.whut.algorithm.high.frequence.offer.problem_offer_18_shan_chu_lian_biao_de_jie_dian_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/30 17:03
 * @desription
 */
public class ShanChuLianBiaoDeJieDianLcof {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 要求时间复杂度为 O（1）
     * <p>
     * 思想 将要删除系欸但那
     *
     * @param head
     * @param deleteNode
     * @return
     */
    public ListNode deleteNode(ListNode head, ListNode deleteNode) {

        /**
         * 分三种情况
         */
        //1. 该结点是非尾结点
        if (deleteNode.next != null) {
            ListNode nxt = deleteNode.next;
            deleteNode.val = nxt.val;
            deleteNode.next = nxt.next;
            nxt = null;

        } else if (head == deleteNode) {
            //只有一个结点
            head = null;
        } else {
            //最后一个结点
            ListNode p = head;

            while (p.next != deleteNode)
                p = p.next;

            p.next = null;
            deleteNode = null;
        }
        return head;
    }

    /**
     * 删除重复的元素  链表中
     *
     * @param head
     */
    public ListNode deleteDuplicates1(ListNode head) {

        if(head == null)
            return null;

        ListNode slow = head, fast = head;

        while (fast != null){
            if(fast.val != slow.val){
                slow.next = fast;
                slow = slow.next;
            }

            fast = fast.next;
        }

        slow.next = null;

        return head;
    }

    /**
     * 返回数组删除后的长度
     *
     * @param nums
     * @return
     */
    public int deleteDuplicates2(int[] nums) {

        if (nums.length == 0)
            return 0;

        int slow = 0, fast = 0;

        int n = nums.length;

        while (fast < n) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }

            fast++;
        }

        return slow + 1;
    }

    public static void main(String[] args) {

    }
}
