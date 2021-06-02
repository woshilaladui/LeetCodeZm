package com.whut.algorithm.high.frequence.list;


/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/1/14 17:15
 * @desription
 */
public class LinkedList {

    public static class ListNode {
        public ListNode next;
        public int val;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static boolean isPalindrome(String s) {

        int left = 0, right = s.length() - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }

        return left >= right;
    }

    /**
     * 递归逆序
     * <p>
     * 图解见书p284
     *
     * @param head
     * @return
     */
    private static ListNode recursionReverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        //last为反转后的序列的头结点
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 递归反转前n个结点，n从1开始
     *
     * @param head
     * @return
     */
    //后驱结点
    static ListNode successorNode = null;

    private static ListNode recursionReverseN(ListNode head, int n) {
        if (n == 1) {
            //找到后驱
            successorNode = head.next;
            return head;
        }

        ListNode last = recursionReverseN(head.next, n - 1);
        head.next.next = head;

        //头结点指向后驱结点
        head.next = successorNode;

        return last;

    }

    /**
     * 反转m到n结点的链表
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    private static ListNode recursionReverseMN(ListNode head, int m, int n) {
        if (m == 1) {
            return recursionReverseN(head, n);
        }
        //head.next 反转区间为[m-1,n-1]
        head.next = recursionReverseMN(head.next, m - 1, n - 1);
        return head;
    }



    /**
     * 反转[a,b]区间的链表
     * @param a
     * @param b
     * @return
     */
    private static ListNode reverse2(ListNode a,ListNode b){
        ListNode pre,cur,nxt;
        pre = null;
        cur = a;
        nxt = a;

        while (cur != b){
            //防止断链
            nxt = cur.next;

            //翻转
            cur.next = pre;

            //更新
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    /**
     * 不带头结点
     *
     * @param head
     * @return
     */
    private static ListNode reverse2(ListNode head) {
        //pre指前驱结点，cur当前结点也就是工作结点,nxt防止断链
        ListNode pre, cur, nxt;

        pre = null;
        cur = head;
        nxt = head;
        while (cur != null) {
            //防止断链
            nxt = cur.next;

            //逆序该结点
            cur.next = pre;

            //更新结点
            pre = cur;
            cur = nxt;
        }
        //返回反转后的头结点
        return pre;
    }

    /**
     * 带头结点的反转
     *
     * @param head
     * @return
     */
    private static ListNode reverse(ListNode head) {

        if (head.next == null)
            return head;

        //p为工作结点，r为防止断链
        ListNode p, r;
        //定义头结点
        ListNode L = new ListNode(0);

        p = head;
        L.next = null;
        while (p != null) {
            r = p.next;
            ListNode pnew = new ListNode(p.val);
            pnew.next = L.next;
            //p.next = L.next;
            L.next = pnew;
            p = r;
        }

        System.out.println("head = " + L.next.val);
        return L.next;
    }

    private static boolean isPalindrome(ListNode head) {
        ListNode left = head;
        ListNode right = reverse(head);
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private static String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r - l - 1);
    }

    public static void main(String[] args) {

//        String s = "abcddcbadftgh";
//        System.out.println(palindrome(s,0,s.length()-1));

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = null;

        System.out.println(listNode1.val);
        System.out.println(listNode1.next.val);
        System.out.println(listNode1.next.next.val);


        listNode1.next = reverse2(listNode2,null);
    //    System.out.println(listNode.val);

        System.out.println(listNode1.val);
        System.out.println(listNode1.next.val);
        System.out.println(listNode1.next.next.val);


        //traverse(listNode1);

//        listNode1 = reverse(listNode1);
//        System.out.println(listNode1.val);

        //System.out.println(isPalindrome(listNode1));

    }

    public static void traverse(ListNode head) {
        if (head == null) return;
        traverse(head.next);
        // 后序遍历代码
        System.out.println(head.val);
    }


}
