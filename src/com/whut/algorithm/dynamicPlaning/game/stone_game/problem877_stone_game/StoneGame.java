package com.whut.algorithm.dynamicPlaning.game.stone_game.problem877_stone_game;

import java.util.Arrays;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2020/12/3 15:55
 * @desription
 */
public class StoneGame {

    public static boolean stoneGame(int[] piles) {


        Arrays.sort(piles);

        int person1 = 0;
        int person2 = 0;

        //3,4,5,5

        for(int i= piles.length-1;i>=0;i= i-2){
            person1 += piles[i];
            person2 +=piles[i-1];
        }



        return person1>person2;
    }

    public static void main(String[] args) {

        int[] piles = new int[]{5,3,4,5};

        System.out.println( stoneGame(piles));

    }
}
