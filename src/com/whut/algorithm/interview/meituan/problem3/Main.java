//package com.whut.algorithm.interview.meituan.problem3;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Random;
//import java.util.Scanner;
//
///**
// * @author Administrator
// * @version 1.0.0
// * @date 2021/8/15 11:42
// * @desription
// */
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int len = scanner.nextInt();
//        int[] arr = new int[len];
//
//        HashMap<Integer, String> map = new HashMap<>();
//
//        for (int i = 0; i < len; i++) {
//            map.put(scanner.nextInt(), scanner.next());
//        }
//
//        int count = 1;
//
//        while (true) {
//            Map<Integer, String> newMap = new HashMap<>();
//
//            for (Map.Entry<Integer, String> entry : map.entrySet()) {
//                int key = entry.getKey();
//                String value = entry.getValue();
//
//                if (value.charAt(0) == 'L') {
//                    key--;
//                } else {
//                    key++;
//                }
//
//                if (newMap.containsKey(key)) {
//                    int idx = value.charAt(1) - '0';
//                    arr[idx] = count;
//                    idx = newMap.get(key).charAt(1) - '0';
//
//                    arr[idx] = count;
//                    newMap.remove(key);
//                } else {
//                    newMap.put(key, value);
//                }
//            }
//
//            if (newMap.keySet().size() == 0 ||check(newMap) == false)
//                break;
//            count++;
//            map = newMap;
//
//        }
//
//
//
//
//    }
//
//    public static boolean check(Map<Integer, String> map) {
//        int left = Integer.MIN_VALUE;
//        int right = Integer.MAX_VALUE;
//        for (Map.Entry<Integer, String> entry : map.entrySet()) {
//            int key = entry.getKey();
//            String value = entry.getValue();
//            if(value.charAt(0) == 'L')
//                left = Math.max(left,key);
//            else
//                right = Math.min(right,key);
//
//            if(left > right)
//                return true;
//        }
//        return false;
//    }
//}

