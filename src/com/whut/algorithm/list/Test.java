package com.whut.algorithm.list;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/18 15:15
 * @desription
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        printDefaultCapacityList();
        printEmptyCapacityList();

    }

    private static void printEmptyCapacityList() {
        ArrayList<Integer> emptyCapacity = new ArrayList<>(0);
        System.out.println(
                "empty 初始化长度：" + getCapacity(emptyCapacity));


        emptyCapacity.add(1);
        System.out.println(
                "empty add 之后 长度：" + getCapacity(emptyCapacity));

    }

    private static void printDefaultCapacityList() {
        ArrayList<Integer> defaultCapacity = new ArrayList<>();
        System.out.println(
                "default 初始化长度：" + getCapacity(defaultCapacity));

        defaultCapacity.add(1);
        System.out.println(
                "default add 之后 长度：" + getCapacity(defaultCapacity));
    }

    public static int getCapacity(ArrayList<?> arrayList) {
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            // 获取 elementData 字段
            Field field = arrayListClass.getDeclaredField("elementData");
            // 开启访问权限
            field.setAccessible(true);
            // 把示例传入get，获取实例字段elementData的值
            Object[] objects = (Object[]) field.get(arrayList);
            //返回当前ArrayList实例的容量值
            return objects.length;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
