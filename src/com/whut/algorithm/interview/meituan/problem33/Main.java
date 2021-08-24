package com.whut.algorithm.interview.meituan.problem33;

import java.util.*;
import java.util.List;

public class Main {
    /**
     * 10
     * 94 R
     * 74 L
     * 90 L
     * 75 R
     * 37 R
     * 99 R
     * 62 R
     * 4 L
     * 92 L
     * 44 R
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int n = scanner.nextInt();
        int n = 2;
//        int []num = new int[]{94,74,90,75,37,99,62,4,92,44};
//        String []arr = new String[]{"R","L","L","R","R","R","R","L","L","R"};
        int []num = new int[]{4,5};
        String []arr = new String[]{"R","L"};
        List<Robot> robotList = new ArrayList<>();
        Map<Integer, Robot> mm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            //System.out.println(n);
            Robot robot = new Robot();
            robot.setIndex(num[i]);
            robot.setFlag(arr[i]);
            robot.setTemp(0);
            robotList.add(robot);
            mm.put(robot.getIndex(), robot);
        }

        while (n > 1) {

            for (Robot r : robotList) {
                if (r.temp != -1) {
                    mm.remove(r.getIndex());
                    r.setTemp(++r.temp);
                    if (r.getFlag().equals("R")) {
                        r.setIndex(++r.index);
                    } else {
                        r.setIndex(--r.index);
                    }
                }

                if (mm.containsKey(r.index)) {
                    r.setTemp(-1);
                    Robot robot = mm.get(r.index);
                    robot.setTemp(-1);
                    n = n - 2;
                    mm.remove(r.getIndex());
                    continue;
                }
                mm.put(r.getIndex(),r);
            }

        }
        for (Robot robot : robotList) {
            System.out.println(robot.getTemp());
        }
    }

    static class Robot {
        int index;
        String flag;
        int temp;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public int getTemp() {
            return temp;
        }

        public void setTemp(int temp) {
            this.temp = temp;
        }
    }
}
