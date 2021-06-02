package com.whut.algorithm.high.frequence.divide_and_conquer.problem315_count_of_smaller_numbers_after_self;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/27 14:23
 * @desription
 */
public class CountOfSmallerNumbersAfterSelfTest {

    private class RelationShipOfIndex {
        public int data;
        public int index;

        public RelationShipOfIndex(int data, int index) {
            this.data = data;
            this.index = index;
        }

        public RelationShipOfIndex(RelationShipOfIndex relationShipOfIndex) {
            this.data = relationShipOfIndex.data;
            this.index = relationShipOfIndex.index;
        }
    }

    /**
     * 思想和 offer51思想一样，求逆序对
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {

        List<Integer> result = new ArrayList<>();

        RelationShipOfIndex[] relationShipOfIndex = new RelationShipOfIndex[nums.length];

        RelationShipOfIndex[] tempRelationShipOfIndex = new RelationShipOfIndex[nums.length];

        int[] tempResult = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            relationShipOfIndex[i] = new RelationShipOfIndex(nums[i], i);
        }

        countSmaller(relationShipOfIndex, 0, nums.length - 1, tempRelationShipOfIndex,tempResult);

//        for (RelationShipOfIndex shipOfIndex : relationShipOfIndex) {
//            System.out.println("key = " + shipOfIndex.data + " index = " + shipOfIndex.index);
//        }

//        for (int i : tempResult) {
//            System.out.print(i+" ");
//        }

        for(int num: tempResult){
            result.add(num);
        }

        return result;
    }

    public void countSmaller(
            RelationShipOfIndex[] relationShipOfIndex,
            int low,
            int high,
            RelationShipOfIndex[] tempRelationShipOfIndex,
            int[] tempResult
    ) {

        if (low == high)
            return;

        int mid = low + (high - low) / 2;

        countSmaller(relationShipOfIndex, low, mid, tempRelationShipOfIndex, tempResult);
        countSmaller(relationShipOfIndex, mid + 1, high, tempRelationShipOfIndex, tempResult);

        merge(relationShipOfIndex, low, mid, high, tempRelationShipOfIndex, tempResult);



    }

    private void merge(
            RelationShipOfIndex[] relationShipOfIndex,
            int low,
            int mid,
            int high,
            RelationShipOfIndex[] tempRelationShipOfIndex,
            int[] tempResult
    ) {

        for (int i = low; i <= high; i++) {
            tempRelationShipOfIndex[i] = relationShipOfIndex[i];
        }

        int i, j, k;

        for (i = low, j = mid + 1, k = low; i <= mid && j <= high; k++) {
            if (tempRelationShipOfIndex[i].data <= tempRelationShipOfIndex[j].data) {
                relationShipOfIndex[k] = tempRelationShipOfIndex[i++];
            } else {
                relationShipOfIndex[k] = tempRelationShipOfIndex[j++];
                for (int p = i; p <= mid; p++) {
                    tempResult[tempRelationShipOfIndex[p].index]++;
                }
            }
        }//end for

        while (i <= mid)
            relationShipOfIndex[k++] = tempRelationShipOfIndex[i++];

        while (j <= high)
            relationShipOfIndex[k++] = tempRelationShipOfIndex[j++];

    }

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelfTest countOfSmallerNumbersAfterSelfTest = new CountOfSmallerNumbersAfterSelfTest();

        countOfSmallerNumbersAfterSelfTest.countSmaller(new int[]{2, -1, -1, -2});
    }
}
