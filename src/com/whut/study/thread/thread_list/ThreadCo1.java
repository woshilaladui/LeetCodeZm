package com.whut.study.thread.thread_list;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/19 10:51
 * @desription
 *
 * 假设今天考试，20个学生，1个监考老师。规定学生可以提前交卷，即把卷子留下，直接走人就行了。
 *
 * 但老师必须等到所有的学生都走后，才可以收卷子，然后装订打包。
 *
 * 如果把学生和老师都看作线程，就是1个线程和20个线程的配合问题，即等20个线程都结束了，这1个线程才开始。
 *
 * 比如20个线程分别在计算数据，等它们都结束后得到20个中间结果，最后这1个线程再进行后续汇总、处理等。
 *
 */
public class ThreadCo1 {

    static final int COUNT = 20;

    public static void main(String[] args) throws Exception {
        new Thread(new Teacher(cdl)).start();
        TimeUnit.SECONDS.sleep(1);
        for (int i = 0; i < COUNT; i++) {
            new Thread(new Student(i, cdl)).start();
        }
        synchronized (ThreadCo1.class) {
            ThreadCo1.class.wait();
        }
    }

    static CountDownLatch cdl = new CountDownLatch(COUNT);

    static class Teacher implements Runnable {
        CountDownLatch cdl;

        Teacher(CountDownLatch cdl) {
            this.cdl = cdl;
        }

        @Override
        public void run() {
            System.out.println("老师发卷子。。。");
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("老师收卷子。。。");
        }

    }

    static class Student implements Runnable {

        CountDownLatch cdl;
        int num;

        Student(int num, CountDownLatch cdl) {
            this.num = num;
            this.cdl = cdl;
        }

        @Override
        public void run() {
            System.out.println(String.format("学生(%d)写卷子。。。", num));
            doingLongTime(this.num);
            System.out.println(String.format("学生(%d)交卷子。。。", num));
            cdl.countDown();
        }

        private void doingLongTime(int num) {
            //System.out.println(String.format("学生%s做卷子",num));
        }

    }
}
