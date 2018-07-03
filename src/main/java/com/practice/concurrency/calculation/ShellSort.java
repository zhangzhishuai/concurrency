package com.practice.concurrency.calculation;

import java.util.Arrays;

/**
 * 希尔排序
 * 1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。
 * 它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
 * <p>
 * 算法描述
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
 * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 按增量序列个数k，对序列进行k 趟排序；
 * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
 * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 * <p>
 * 算法分析
 * 希尔排序的核心在于间隔序列的设定。既可以提前设定好间隔序列，也可以动态的定义间隔序列。
 * 动态定义间隔序列的算法是《算法（第4版）》的合著者Robert Sedgewick提出的。
 *
 * @author hetao
 * @create 2018-07-02 下午4:34
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {26, 53, 67, 48, 57, 13, 48, 32, 60, 50};
//        int[] arrNew = shellSort(arr);
        int[] arrNew = dynamicShelSort(arr);
        System.out.println("ShellSort.main: " + Arrays.toString(arrNew));
    }

    /**
     * 希尔排序具体实现
     *
     * @param arr
     * @return
     */
    private static int[] shellSort(int[] arr) {
        int j = 0;
        int temp = 0;
        for (int increment = arr.length / 2; increment > 0; increment /= 2) {
            System.out.println("increment:" + increment);
            for (int i = increment; i < arr.length; i++) {
                System.out.println("i:" + i);
                temp = arr[i];
                for (j = i - increment; j >= 0; j -= increment) {
                    if (temp < arr[j]) {
                        arr[j + increment] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + increment] = temp;
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }

        return arr;
    }

    /**
     * 希尔排序具体实现 - 动态定义间隔序列
     *
     * @param arr
     * @return
     */
    private static int[] dynamicShelSort(int[] arr) {
        int len = arr.length,
                temp,
                gap = 1;
        int j;

        // 动态定义间隔序列
        while (gap < len / 3) {
            gap = gap * 3 + 1;
        }

        for (int increment = gap; increment > 0; increment /= 3) {
            System.out.println("increment:" + increment);
            for (int i = increment; i < len; i++) {
                System.out.println("i:" + i);
                temp = arr[i];
                for (j = i - increment; j >= 0 && arr[j] > temp; j -= increment) {
                    arr[j + increment] = arr[j];
                }
                arr[j + increment] = temp;
            }

            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }

        return arr;
    }


}
