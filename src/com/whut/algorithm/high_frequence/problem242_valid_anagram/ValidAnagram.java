package com.whut.algorithm.high_frequence.problem242_valid_anagram;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/29 18:40
 * @desription
 */
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {


        String temp;

        if(s.length() < t.length()){
            temp = s;
            s = t;
            t = temp;
        }

        Map<Character, Integer> map_s = new HashMap<>();

        Map<Character, Integer> map_t = new HashMap<>();

        char[] c_s = s.toCharArray();
        char[] c_t = t.toCharArray();

        for (char c : c_s) {
            if (map_s.containsKey(c)) {
                map_s.put(c, map_s.get(c) + 1);
            } else {
                map_s.put(c, 1);
            }
        }

        for (char c : c_t) {
            if (map_t.containsKey(c)) {
                map_t.put(c, map_t.get(c) + 1);
            } else {
                map_t.put(c, 1);
            }
        }

        Iterator<Character> iterator = map_s.keySet().iterator();

        while (iterator.hasNext()) {

            char c = iterator.next();

            if(!map_s.get(c).equals(map_t.get(c)))
                return false;

        }

        return true;
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "ab";

        System.out.println(isAnagram(s, t));
    }
}
