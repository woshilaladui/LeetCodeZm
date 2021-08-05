package com.whut.algorithm.high.frequence.common.problem_76_minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/20 15:14
 * @desription
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {

        //滑动窗口
        if (s.equals(t))
            return t;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        //初始化need window窗口
        for (char c : tArray) {
            window.put(c, 0);
            if (need.containsKey(c)) {
                need.put(c, need.get(c) + 1);
            } else {
                need.put(c, 1);
            }
        }

        int left = 0, right = 0;
        int start = 0, len = Integer.MAX_VALUE;

        //符合条件的字符个数
        int vaild = 0;

        while (right < sArray.length) {
            char in = sArray[right];
            right++;

            //判断合法性
            if (need.containsKey(in)) {
                window.put(in, window.get(in) + 1);

                if(need.get(in).equals(window.get(in)))
                    vaild++;
            }

            //判断是否需要收缩窗口
            while (vaild == need.size()){

                //判断长度
                //在这里更新最小覆盖串
                if ((right - left) < len) {
                    //注意right已经++
                    start = left;
                    len = right - left;
                }

                //移除窗口
                char out = sArray[left];
                left++;

                //对窗口做更新
                if(window.containsKey(out)){

                    if(window.get(out).equals(need.get(out)))
                        vaild--;

                    window.put(out,window.get(out)-1);

                }


            }
        }


        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    static class Thread1 extends Thread{
        @Override
        public void run() {
            for(int i=0;i<20;i++){
                yield();
                System.out.println("thread1");
            }

        }
    }

    static class Thread2 extends Thread{
        @Override
        public void run() {
            for(int i=0;i<20;i++){
                Thread.yield();
                System.out.println("thread2");
            }

        }
    }

    static class Thread3 extends Thread{
        @Override
        public void run() {
            for(int i=0;i<20;i++)
                yield();
                System.out.println("thread3");
        }
    }

    static class Thread4 extends Thread{
        @Override
        public void run() {
            for(int i=0;i<20;i++){
                yield();
                System.out.println("thread4");
            }

        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread1();
        thread1.setPriority(3);
        Thread thread2 = new Thread2();
        thread2.setPriority(6);
        Thread thread3 = new Thread3();
        Thread thread4 = new Thread4();
        thread4.setPriority(9);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}
