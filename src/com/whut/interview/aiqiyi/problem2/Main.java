package com.whut.interview.aiqiyi.problem2;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/22 15:54
 * @desription
 */

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class Main {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition zeroCodition = lock.newCondition();
    private static Condition evenCodition = lock.newCondition();
    private static Condition oddCodition = lock.newCondition();


    public static void main(String[] args) {
        final Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n, lock);
        new Thread(() -> {
            try {
                zeroEvenOdd.printZero(System.out::print, zeroCodition, evenCodition, oddCodition);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.printEven(System.out::print, evenCodition, zeroCodition);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.printOdd(System.out::print, oddCodition, zeroCodition);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        try {
            // 先唤醒a
            zeroCodition.signal();
        } finally {
            lock.unlock();
        }

    }
}

class ZeroEvenOdd {
    private int n;

    private int start;

    private Lock lock;

    private int flag = 1;

    public ZeroEvenOdd(int n, ReentrantLock lock) {
        this.n = n;
        this.start = 0;
        this.lock = lock;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void printZero(IntConsumer printNumber, Condition cur, Condition even, Condition odd) throws InterruptedException {

        while (this.start != n) {
            lock.lock();
            // 获取锁之后等待
            try {
                if (this.start == n)
                    break;
                cur.await();
                printNumber.accept(0);
                this.start++;
                if (flag % 2 == 0) {
                    //唤醒偶数
                    even.signal();
                } else {
                    odd.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    lock.unlock();
                } catch (Exception e) {

                }
            }

        }
    }

    public void printEven(IntConsumer printNumber, Condition cur, Condition zero) throws InterruptedException {
        while (this.start != n) {
            lock.lock();
            // 获取锁之后等待
            try {
                if (this.start == n - 1)
                    break;
                cur.await();

                printNumber.accept(this.start);
                zero.signal();
                flag = 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    lock.unlock();
                } catch (Exception e) {

                }
            }


        }
    }

    public void printOdd(IntConsumer printNumber, Condition cur, Condition zero) throws InterruptedException {
        while (this.start != n) {
            lock.lock();
            // 获取锁之后等待
            try {
                if (this.start == n - 1)
                    break;
                cur.await();
                printNumber.accept(this.start);
                zero.signal();
                flag = 2;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    lock.unlock();
                } catch (Exception e) {

                }
            }

        }
    }


}
