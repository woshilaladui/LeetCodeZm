package com.whut.algorithm.high.frequence.utils;

import java.util.Calendar;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/6/22 9:55
 * @desription
 */
public class PackageAndClassNameUtils {

    public static String getPackageName(String name) {

        return name.replaceAll("-", "_");
    }

    public static String getClassName(String name) {

        String[] names = name.split("-");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < names.length; i++) {
            sb.append(names[i].substring(0, 1).toUpperCase())
                    .append(names[i].substring(1));
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String name = "path-sum-iii";

        System.out.println(getPackageName(name));
        System.out.println(getClassName(name));
    }

}
