package com.whut.algorithm.common.problem215_kth_largest_element_in_an_array;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/6 15:46
 * @desription
 */
public class KthLargestElementInAnArray {

    private static int partition(int[] A, int low, int high) {

        int privotkey = A[low];

        while (low < high) {

            while (low < high && A[high] >= privotkey)
                high--;

            A[low] = A[high];

            while (low < high && A[low] <= privotkey)
                low++;

            A[high] = A[low];

        }

        A[low] = privotkey;

        return low;
    }

    private static void adjust(int[] A, int low, int high) {
        int i = low;

        int temp = A[low];

        for (int j = i * 2 + 1; j <= high; j = j* 2 + 1) {
            //子节点最大的
            if (j < high && A[j] < A[j + 1])
                j++;

            if (temp >= A[j])
                break;
            else {
                A[i] = A[j];
                i = j;
            }
        }

        A[i] = temp;
    }

    private static void buildHeap(int[] A, int low, int high) {
        for (int i = A.length / 2 - 1; i >= 0; i--)
            adjust(A, i, high);
    }

    public static int findKthLargest(int[] nums, int k) {
        buildHeap(nums, 0, nums.length - 1);

        for (int i = nums.length - 1; i >= 0; i--) {


            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            adjust(nums,0,i-1);
            k--;
//            System.out.println("k = " + k);
//
//            System.out.println("nums[0] = " + nums[0]);
//            if(k == 0)
//                return nums[0];
        }
        return -1;

    }

    private static void heapSort(int[] A, int low, int high) {

        buildHeap(A, low, high);

        //int k = 2;

        for (int i = A.length - 1; i >= 0; i--) {

            System.out.println("num[0] = "+ A[0]);
            int temp = A[i];
            A[i] = A[0];
            A[0] = temp;


            adjust(A, 0, i - 1);
        }


    }

    private static void qukilySort(int[] A, int low, int high) {

        if (low <= high) {
            int partionLoc = partition(A, low, high);
            qukilySort(A, low, partionLoc - 1);
            qukilySort(A, partionLoc + 1, high);
        }

    }

    public static void main(String[] args) {
        int[] A = new int[]{3,1,2,4};

//        [3,2,3,1,2,4,5,5,6]
//        4
        //System.out.println(findKthLargest(A,2));



        //qukilySort(A, 0, A.length - 1);
        heapSort(A, 0, A.length - 1);
        for (int i : A) {
            System.out.print(i + " ");
        }
    }
}
