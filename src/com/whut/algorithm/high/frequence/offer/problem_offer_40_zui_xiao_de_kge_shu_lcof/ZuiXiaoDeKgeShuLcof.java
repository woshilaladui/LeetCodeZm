package com.whut.algorithm.high.frequence.offer.problem_offer_40_zui_xiao_de_kge_shu_lcof;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/7/26 21:41
 * @desription
 */
public class ZuiXiaoDeKgeShuLcof {


    private int partion(int[] arr, int low, int high) {

        int pivotKey = arr[low];

        while (low < high) {

            //从右边调整
            while (low < high && arr[high] >= pivotKey)
                high--;

            arr[low] = arr[high];

            while (low < high && arr[low] <= pivotKey)
                low++;

            arr[high] = arr[low];

        }

        //枢轴归位
        arr[low] = pivotKey;

        return low;
    }

    public int[] getLeastNumbers(int[] arr, int k) {

        int []outPut = new int[k];

        if(k == 0)
            return outPut;

        int low = 0;
        int high = arr.length-1;

        int index = partion(arr, low, high);

        while (index != k - 1) {
            if(index > k-1){
                high = index-1;
                index = partion(arr,low,high);
            }else {
                low = index+1;
                index = partion(arr,low,high);
            }
        }

        System.arraycopy(arr,0,outPut,0,k);
        return outPut;
    }

    public static void main(String[] args) {
//        int []arr = new int[]{4,5,1,6,2,7,3,8};
//
//        int []outPut = new int[4];
//
//        ZuiXiaoDeKgeShuLcof zuiXiaoDeKgeShuLcof = new ZuiXiaoDeKgeShuLcof();
//
//        outPut = zuiXiaoDeKgeShuLcof.getLeastNumbers(arr,4);
//
//        for (int i : outPut) {
//            System.out.print(i+" ");
//        }

        System.out.println(1234%100);
    }
}
