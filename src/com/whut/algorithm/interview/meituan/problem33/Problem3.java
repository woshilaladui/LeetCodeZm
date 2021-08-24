package com.whut.algorithm.interview.meituan.problem33;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/15 20:23
 * @desription
 */
public class Problem3 {
    public static void main(String[] args) {
        int[] num = new int[]{94, 74, 90, 75, 37, 99, 62, 4, 92, 44};
        String[] arr = new String[]{"R", "L", "L", "R", "R", "R", "R", "L", "L", "R"};

        f(num,arr,num.length);
    }

    private static void f(int[] nums, String[] direction, int n) {
        List<Robot> robotList = new ArrayList<>();
        //存放当前
        Map<Integer, Robot> map = new HashMap<>();

        int maxL = Integer.MIN_VALUE;
        int minR = Integer.MAX_VALUE;

        //初始化
        for (int i = 0; i < n; i++) {
            Robot robot = new Robot();

            robot.index = nums[i];
            robot.step = 0;
            robot.dead = false;
            robot.flag = direction[i];

            if (robot.flag.equals("L")) {
                maxL = Math.max(maxL, nums[i]);
            } else {
                minR = Math.min(minR, nums[i]);
            }

            robotList.add(robot);
            map.put(robot.index, robot);
        }


        while (n > 1 ) {
            if(minR > maxL)
                break;



            for (Robot robot : robotList) {
                //机器人还活着
                if (!robot.dead) {
                    //移动机器人
                    if (robot.flag.equals("R")) {
                        ++robot.index;
                        minR = Math.min(minR, robot.index);
                    } else {
                        --robot.index;
                        maxL = Math.max(maxL, robot.index);
                    }
                    ++robot.step;
                }else
                    continue;

                //将原有的位置上的机器人移除
                if (robot.flag.equals("R")) {
                    map.remove(robot.index - 1);
                } else {
                    map.remove(robot.index + 1);
                }

                if(robot.flag.equals("R")){
                    if(map.containsKey(robot.index+1)){
                        //设置两个机器人死亡
                        robot.dead = true;
                        Robot robot2 = map.get(robot.index+1);

                        robot2.dead = true;
                        n -= 2;
                        //将他们两个从map中移除
                        map.remove(robot.index);
                        //上面移除了一个
                        continue;
                    }
                }else {
                    if(map.containsKey(robot.index-1)){
                        //设置两个机器人死亡
                        robot.dead = true;
                        Robot robot2 = map.get(robot.index-1);

                        robot2.dead = true;
                        n -= 2;
                        //将他们两个从map中移除
                        map.remove(robot.index);
                        //上面移除了一个
                        continue;
                    }
                }

                map.put(robot.index, robot);

            }
        }

        for (Robot robot : robotList) {
            System.out.println(robot.dead ? robot.step : -1);
        }

    }

    static class Robot {
        //当前位置
        public int index;
        //是否死亡
        boolean dead;

        int step;

        String flag;
    }

}
