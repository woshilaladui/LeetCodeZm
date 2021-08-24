//package com.whut.interview.tencent.problem1;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Administrator
// * @version 1.0.0
// * @date 2021/8/22 20:08
// * @desription
// */
//public class Main {
//
//    public class ListNode {
//        int val;
//        ListNode next = null;
//
//        ListNode(int val) {
//            this.val = val;
//        }
//    }
//
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     * @param m int整型
//     * @param a ListNode类 指向彩带的起点，val表示当前节点的val，next指向下一个节点
//     * @return ListNode类一维数组
//     */
//    public ListNode[] solve(int m, ListNode a) {
//            // write code here
//            //List<List<Integer>> result = new ArrayList<>();
//
//            ListNode[] result = new ListNode[m];
//
//            while (a != null) {
//
//                int index = a.val % m;
//
//                if (result[index] == null) {
//                    result[index] = new ListNode(a.val);
//                } else {
//                    ListNode p = result[index];
//                    while (p.next != null) {
//                        p = p.next;
//                    }
//                    p.next = new ListNode(a.val);
//                }
//
//                a = a.next;
//
//            }
//
//            return result;
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
//package com.whut.interview.tencent.problem1;
//
//import java.util.ArrayList;
//import java.util.List;

///**
// * @author Administrator
// * @version 1.0.0
// * @date 2021/8/22 20:08
// * @desription
// */
public class Main {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param m int整型
     * @param a ListNode类 指向彩带的起点，val表示当前节点的val，next指向下一个节点
     * @return ListNode类一维数组
     */
    public ListNode[] solve(int m, ListNode a) {
        // write code here
        //List<List<Integer>> result = new ArrayList<>();

        ListNode[] result = new ListNode[m];
        ListNode[] lastNode = new ListNode[m];
        ListNode p;

        while (a != null) {

            int index = a.val % m;

            ListNode nxt = a.next;
            a.next = null;
            if (result[index] == null) {
                result[index] = a;
                lastNode[index] = a;
                //result[index] = new ListNode(a.val);
            } else {
                p = lastNode[index];

                p.next = a;

                lastNode[index] = a;

//                while (p.next != null) {
//                    p = p.next;
//                }
//                p.next = a;
            }

            a = nxt;

        }

        return result;
    }

    public static void main(String[] args) {

    }
}

