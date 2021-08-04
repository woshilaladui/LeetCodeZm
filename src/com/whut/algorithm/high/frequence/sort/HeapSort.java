package com.whut.algorithm.high.frequence.sort;


/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/3/1 19:24
 * @desription
 */
public class HeapSort {


    /**
     *
     * O(nlogn)
     *
     * 不稳定排序
     *
     */
    public static class Heap {
        public int[] elem;
        public int length;

        public Heap() {
        }

        public Heap(int[] elem, int length) {
            this.elem = elem;
            this.length = length;
        }
    }

    public static void adjust(Heap heap, int low, int high) {
        int i = low;

        //临时存储
        int temp = heap.elem[low];

        for (int j = 2 * i + 1; j <= high; j = j * 2 + 1) {

            //选择孩子节点中大的节点
            if (j < high && heap.elem[j] > heap.elem[j + 1])
                j++;

            //判断需不需要交换子父节点
            if (temp < heap.elem[j])
                break;

            else {
                //交换子父节点
                heap.elem[i] = heap.elem[j];

                i = j;
            }

        }//end for
        heap.elem[i] = temp;
    }

    public static void buildHeap(Heap heap) {

        //从最后一个非叶子节点开始调整
        for (int i = heap.length / 2 - 1; i >= 0; i--)
            adjust(heap, i, heap.length - 1);

    }

    public static void heapSort(Heap heap) {
        //构建heap
        buildHeap(heap);

        //堆排序
        //每次把堆顶数据移除
        for (int i = heap.length - 1; i >= 0; i--) {
            //将最大的最末尾
            System.out.print(heap.elem[0] + " ");

            int temp = heap.elem[i];
            heap.elem[i] = heap.elem[0];
            heap.elem[0] = temp;


            //重新调整
            adjust(heap, 0, i - 1);
        }
    }

    /**
     * 87
     * 78  65
     * 32 45 53 4
     * 17
     *
     * @param args
     */

    public static void main(String[] args) {
        Heap heap = new Heap();

        heap.elem = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};

        heap.length = heap.elem.length;

        heapSort(heap);

        System.out.println();

        for(int i =0;i<heap.elem.length;i++)
            System.out.print(heap.elem[i]+" ");
    }
}
