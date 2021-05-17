package com.whut.algorithm.thread.thread_list;

import java.util.concurrent.CyclicBarrier;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/19 11:46
 * @desription
 * 最近景色宜人，公司组织去登山，大伙都来到了山脚下，登山过程自由进行。
 *
 * 但为了在特定的地点拍集体照，规定1个小时后在半山腰集合，谁最后到的，要给大家表演一个节目。
 *
 * 然后继续登山，在2个小时后，在山顶集合拍照，还是谁最后到的表演节目。
 *
 * 接着开始下山了，在2个小时后在山脚下集合，点名回家，最后到的照例表演节目。
 *
 */
public class ThreadCo2 {

    static final int COUNT = 5;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < COUNT; i++) {
            new Thread(new Staff(i, cb)).start();
        }
        synchronized (ThreadCo2.class) {
            ThreadCo2.class.wait();
        }
    }


    static CyclicBarrier cb = new CyclicBarrier(COUNT, new Singer());

    static class Singer implements Runnable {

        @Override
        public void run() {
            System.out.println("为大家唱歌。。。");
        }

    }

    static class Staff implements Runnable {

        CyclicBarrier cb;
        int num;

        Staff(int num, CyclicBarrier cb) {
            this.num = num;
            this.cb = cb;
        }

        @Override
        public void run() {
            System.out.println(String.format("员工(%d)出发。。。", num));

            doingLongTime();
            System.out.println(String.format("员工(%d)到达地点一。。。", num));

            try {
                cb.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(String.format("员工(%d)再出发。。。", num));

            doingLongTime();
            System.out.println(String.format("员工(%d)到达地点二。。。", num));
            try {
                cb.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(String.format("员工(%d)再出发。。。", num));

            doingLongTime();
            System.out.println(String.format("员工(%d)到达地点三。。。", num));
            try {
                cb.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(String.format("员工(%d)结束。。。", num));
        }

        private void doingLongTime() {
        }

    }

}
