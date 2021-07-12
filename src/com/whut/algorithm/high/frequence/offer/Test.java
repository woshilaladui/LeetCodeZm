package com.whut.algorithm.high.frequence.offer;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/9 15:51
 * @desription
 */
public class Test {

    public static boolean isPopList(int[] popped) {

        boolean isDown = false;

        if (popped.length == 1 || popped.length == 2)
            return true;

        for (int i = 0; i < popped.length - 1; i++) {

            if(isDown && popped[i] < popped[i+1])
                return false;

            if(popped[i] >= popped[i+1])
                isDown = true;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPopList(new int[]{4,3,5,1,2}));

    }
}
