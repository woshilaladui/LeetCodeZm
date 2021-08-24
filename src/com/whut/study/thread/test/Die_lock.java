package com.whut.study.thread.test;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/19 19:28
 * @desription
 */
/**
 * demo:该案例为了展示死锁
 */
public class Die_lock {
    //创建两个锁的对象
    public static String as="as";
    public static String bs="bs";

    public static void main(String[] args) {
        //开启两个线程
        new Thread(new A()).start();
        new Thread(new B()).start();
    }
}
class A implements Runnable{
    @Override
    public void run() {
        while(true){
            synchronized (Die_lock.as){
                System.out.println("a被上锁！");
                try {
                    //让B有时间锁住b
                    Thread.sleep(3000);
                    synchronized (Die_lock.bs){
                        System.out.println("a中锁b");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class B implements Runnable{
    @Override
    public void run() {
        while(true){
            synchronized (Die_lock.bs){
                System.out.println("b被上锁！");
                try {
                    Thread.sleep(3000);
                    synchronized (Die_lock.as){
                        System.out.println("b中锁a");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

