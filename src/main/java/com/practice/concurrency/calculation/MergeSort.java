package com.practice.concurrency.calculation;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.Arrays;

/**
 * 归并排序算法
 * <p>
 * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 * <p>
 * 算法描述
 * 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 对这两个子序列分别采用归并排序；
 * 将两个排序好的子序列合并成一个最终的排序序列。
 *
 * @author hetao
 * @create 2018-07-05 下午1:49
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1};
        MergeSort(arr);
        System.out.println("MergeSort.main arrNew: " + Arrays.toString(arr));

    }

    /**
     * 归并排序 具体实现
     * 递归调用
     *
     * @param arr
     * @return
     */
    private static void MergeSort(int[] arr) {
        System.out.println("开始排序");
        Sort(arr, 0, arr.length - 1);
    }

    private static void Sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        //二路归并排序里面有两个Sort，多路归并排序里面写多个Sort就可以了
        Sort(arr, left, mid);
        Sort(arr, mid + 1, right);
        merge(arr, left, mid, right);

    }


    private static void merge(int[] a, int left, int mid, int right) {
        int number = 0;
        int[] tmp = new int[a.length];
        int r1 = mid + 1;
        int tIndex = left;
        int cIndex = left;
        // 逐个归并
        while (left <= mid && r1 <= right) {
            if (a[left] <= a[r1]) {
                tmp[tIndex++] = a[left++];
            } else {
                tmp[tIndex++] = a[r1++];
            }

        }
        // 将左边剩余的归并
        while (left <= mid) {
            tmp[tIndex++] = a[left++];
        }
        // 将右边剩余的归并
        while (r1 <= right) {
            tmp[tIndex++] = a[r1++];
        }


        System.out.println("第" + (++number) + "趟排序:\t");
        //从临时数组拷贝到原数组
        while (cIndex <= right) {
            a[cIndex] = tmp[cIndex];
            //输出中间归并排序结果
            System.out.print(a[cIndex] + "\t");
            cIndex++;
        }
        System.out.println();
    }
}
