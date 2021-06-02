package com.whut.study.thread.thread_list;

import java.util.Random;
import java.util.concurrent.Phaser;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/2/19 14:02
 * @desription
 *
 * 这是一个充满魔性的小游戏，由一个团队一起参加。所有人每隔5秒钟抽一次签，每个人有50%的概率留下来或被淘汰。
 *
 * 留下来的人下次抽签时同样有50%的概率被淘汰。被淘汰的人下次抽签时同样有50%的概率复活。
 *
 * 团队所有成员都被淘汰完，为挑战失败，团队所有成员都回到游戏中（除刚开始外），为挑战成功。
 *
 * 比如一开始10人参与游戏，第一轮抽签后，6人留下，4人淘汰。
 *
 * 第二轮抽签后，留下的6人中4人被淘汰，淘汰的4人中2人复活，那么目前是4人在游戏中，6人被淘汰。
 *
 * 一直如此继续下去，直到10人全部被淘汰，或全部回到游戏中。
 *
 * 可见，人数越多，全部被淘汰的概率越小，但全部回到游戏中的概率也越小。
 *
 * 反之，人数越少，全部回到游戏中的概率越大，但全部被淘汰的概率也越大。
 */
public class ThreadCo4 {
    static final int COUNT = 6;

    public static void main(String[] args) throws Exception {
        new Thread(new Challenger("张三")).start();
        new Thread(new Challenger("李四")).start();
        new Thread(new Challenger("王五")).start();
        new Thread(new Challenger("赵六")).start();
        new Thread(new Challenger("大胖")).start();
        new Thread(new Challenger("小白")).start();
        synchronized (ThreadCo4.class) {
            ThreadCo4.class.wait();
        }
    }

    static Phaser ph = new Phaser() {

        protected boolean onAdvance(int phase, int registeredParties) {
            System.out.println(String.format("第(%d)局，剩余[%d]人", phase, registeredParties));

            return registeredParties == 0 ||
                    (phase != 0 && registeredParties == COUNT);
        };
    };

    static class Challenger implements Runnable {

        String name;
        int state;

        Challenger(String name) {
            this.name = name;
            this.state = 0;
        }

        @Override
        public void run() {
            System.out.println(String.format("[%s]开始挑战。。。", name));

            ph.register();
            int phase = 0;
            int h;
            while (!ph.isTerminated() && phase < 100) {
                doingLongTime(5);
                if (state == 0) {
                    if (Decide.goon()) {
                        h = ph.arriveAndAwaitAdvance();
                        if (h < 0)
                            System.out.println(String.format("No%d.[%s]继续，但已胜利。。。", phase, name));

                        else
                            System.out.println(String.format("No%d.[%s]继续at(%d)。。。", phase, name, h));

                    } else {
                        state = -1;
                        h = ph.arriveAndDeregister();
                        System.out.println(String.format("No%d.[%s]退出at(%d)。。。", phase, name, h));

                    }
                } else {
                    if (Decide.revive()) {
                        state = 0;
                        h = ph.register();
                        if (h < 0)
                            System.out.println(String.format("No%d.[%s]复活，但已失败。。。", phase, name));

                        else
                            System.out.println(String.format("No%d.[%s]复活at(%d)。。。", phase, name, h));

                    } else {
                        System.out.println(String.format("No%d.[%s]没有复活。。。", phase, name));
                    }
                }
                phase++;
            }
            if (state == 0) {
                ph.arriveAndDeregister();
            }
            System.out.println(String.format("[%s]结束。。。", name));
        }

        private void doingLongTime(int i) {
        }

    }

    static class Decide {

        private static Random random = new Random();

        static boolean goon() {
            return random.nextInt()*11 > 4;
        }

        static boolean revive() {
            return random.nextInt()*11 < 5;
        }
    }
}
