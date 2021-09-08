package com.whut.algorithm.high.frequence.common.problem71_simplify_path;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/9/2 16:31
 * @desription
 */
public class SimplifyPath {
    public static void main(String[] args) {
        String strs = "/a/./b/../../c/";
        String[] split = strs.split("/");

        System.out.println(simplifyPath("/home//foo/"));

    }

    public static String simplifyPath(String path) {

//        Deque<String> stack = new ArrayDeque<>();
        List<String> stack = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String[] splits = path.split("/");

        for (int i = 0; i < splits.length; i++) {
            if (splits[i].equals(".") || splits[i].equals(""))
                continue;
            if (splits[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.remove(stack.size() - 1);
                }
                continue;
            }
            stack.add(splits[i]);
        }

        for (String s : stack) {
            sb.append("/").append(s);
        }
        String result = sb.toString();

        return result.equals("") ? "/" : result;
    }
}
