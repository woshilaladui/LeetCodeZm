package com.whut.interview.wy.Problem1;

import java.util.*;


/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/8/21 15:03
 * @desription
 */
public class Main {

    public static void backTrack2(List<List<Integer>> result, List<Integer> path, int M, int[] nums, int index) {
        if (path.size() == 2) {
            result.add(new ArrayList<>(path));
            System.out.println(path);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (path.isEmpty()) {
                if (nums[i] > M) {
                    continue;
                }
                path.add(nums[i]);

            } else {
                if (path.get(0) + nums[i] <= M) {
                    path.add(nums[i]);
                } else {
                    continue;
                }
            }

            backTrack2(result, path, M, nums,index+1);
            path.remove(path.size() - 1);

        }//end for

    }

    public static void backTrack(List<List<Integer>> result, List<Integer> path, int M, int[] nums, boolean[] vis) {

        if (path.size() == 2) {
            result.add(new ArrayList<>(path));
            System.out.println(path);
            return;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (!vis[i] && !set.contains(nums[i])) {

                if (path.isEmpty()) {
                    if (nums[i] > M) {
                        continue;
                    }
                    path.add(nums[i]);
                    set.add(nums[i]);
                } else {
                    if (path.get(0) + nums[i] <= M) {
                        path.add(nums[i]);
                        set.add(nums[i]);
                    } else {
                        continue;
                    }
                }

                vis[i] = true;
                backTrack(result, path, M, nums, vis);
                path.remove(path.size() - 1);
                vis[i] = false;
            }
        }//end ofr

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        int M = scanner.nextInt();

        String[] strs = str.split(" ");


        int[] nums = new int[strs.length];

        for (int i = 0; i < strs.length; i++) {

            nums[i] = Integer.parseInt(strs[i]);
        }
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        boolean[] vis = new boolean[nums.length];
        backTrack(result, path, M, nums, vis);
        backTrack2(result, path, M, nums, 0);
        System.out.println(result.size());
    }
}
