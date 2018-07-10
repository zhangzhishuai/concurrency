package com.practice.concurrency.calculation;

import java.util.Arrays;

/**
 * 堆排序
 *
 * 堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。
 * 堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
 *
 * 算法描述
 * 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
 * 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
 * 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，
 * 然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。
 * 不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 *
 * @author hetao
 * @create 2018-07-07 下午1:37
 */
public class HeapSort {


    /**
     * // 因为声明的多个函数都需要数据长度，所以把len设置成为全局变量
     */
    static int len;

    public static void main(String[] args) {
        int[] arr = {21,3,1,45,8,90,6,18,37};
        int[] arrNew = heapSort(arr);
        System.out.println("HeapSort.main arrNew: " + Arrays.toString(arrNew));
    }

    /**
     * // 建立大顶堆
     * @param arr
     */
    private static void buildMaxHeap(int[] arr) {
        len = arr.length;
        for (int i = len / 2; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    /**
     * // 堆调整
     * @param arr
     * @param i
     */
    private static void heapify(int[] arr,int i) {
        int left = 2 * i + 1,
                right = 2 * i + 2,
                largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest);
        }
    }

    /**
     * 替换
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int[] heapSort(int[] arr) {
        buildMaxHeap(arr);

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0);
        }
        return arr;
    }
}
