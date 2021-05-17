package com.whut.algorithm.high_frequence.problem93_restore_ip_addresses;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/4/16 10:35
 * @desription
 */
public class RestoreIpAddresses {

    public static List<String> restoreIpAddresses(String s) {

        int len = s.length();

        List<String> result = new LinkedList<>();

        if (len < 4 || len > 12)
            return result;

        backTrack(s,len,0,4,new LinkedList<>(),result);

//        for (String s1 : result) {
//            System.out.println(s1);
//        }
        return result;
    }

    /**
     * @param s
     * @param len
     * @param begin   每个ip段开始的位置
     * @param residue 1,2,3,4 个ip段，剩余ip段个数
     * @param path    中间路径
     * @param result  最终结果
     */
    public static void backTrack(
            String s,
            int len,
            int begin,
            int residue,
            List<String> path,
            List<String> result
    ) {
        if (begin == len) {
            if (residue == 0) {
                result.add(String.join(".", path));
            }
            return;
        }

        for (int i = begin; i < begin + 3; i++) {
            //剪枝
            if (i >= len)
                break;

            //不够分
            /**
             *
             * 25525511135
             *
             * 255.2.  5511135 还要被分为2个ip段 显然不可以
             *
             * residue * 3  还需要的数字个数
             * len - i 为实际有的数字个数
             */
            if (residue * 3 < len - i)
                continue;

            if (judgeIpSegment(s, begin, i)) {
                String currentIpSegment = s.substring(begin, i + 1);

                path.add(currentIpSegment);
                backTrack(s, len, i + 1, residue - 1, path, result);
                path.remove(path.size() - 1);

            }
        }
    }

    private static boolean judgeIpSegment(String s, int left, int right) {

        int len = right - left + 1;

        //不能以0开头
        if (len > 1 && s.charAt(left) == '0')
            return false;

        int res = 0;

        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }

        return res >= 0 && res <= 255;
    }

    public static void main(String[] args) {
        List<String>  result = restoreIpAddresses("25525511135");

        for (String s : result) {
            System.out.println(s);
        }
    }
}
