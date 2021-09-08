package com.whut.interview.shenceshuju.problem2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/7 10:13
 * @desription
 */
public class Main {
    private static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[7];
        for (int i = 0; i < 7; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] moneys = new int[]{1, 2, 5, 10, 20, 50, 100};
        int sum = scanner.nextInt();
        int[] nums = new int[7];
        backTrack(arr, sum, 0, nums, moneys, 0);
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                for (int i = 0; i < o1.size(); i++) {
                    if (o1.get(i) < o2.get(i))
                        return -1;
                    else if (o1.get(i) > o2.get(i))
                        return 1;
                }
                return 0;
            }
        });
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size()-1; j++) {
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println(res.get(i).get(6));
        }
    }

    /**
     * 2 1 3 2 0 0 0
     * 24
     *
     * @param arr
     * @param sum
     * @param count
     * @param nums
     * @param moneys
     * @param index
     */
    private static void backTrack(
            int[] arr,
            int sum,
            int count,
            int[] nums,
            int[] moneys,
            int index
    ) {
        if (count == sum) {
            List<Integer> tem = arrayToList(nums);
            res.add(tem);
            return;
        }
        if (index == arr.length) {
            return;
        }

        for (int i = index; i < 7; i++) {
            if (arr[i] > 0 && sum >= moneys[i] + count) {
                nums[i]++;
                arr[i]--;
                backTrack(arr, sum, count + moneys[i], nums, moneys, i);
                nums[i]--;
                arr[i]++;

            }
        }
    }

    private static List<Integer> arrayToList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return list;
    }

//    private static void backTrack(
//            List<List<Integer>> result,
//            List<Integer> path,
//            int money,
//            int[] arr,
//            int sum
//    ) {
//        if (path.size() == arr.length) {
//            if (sum == money) {
//                result.add(new ArrayList<>(path));
//                return;
//            }
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//
//        }
//    }
}
