package com.practice.concurrency.java8;

import java.util.*;

/**
 * 测试java8的最大值方法
 * 看了一下源码，发现并行Stream使用到了ForkJoinTask（  ForkJoinTask是专为执行并行任务而生的）
 * 在普通电脑上使用并行的代价太高，或许在大型服务器上核数比较多，才能体现出并行的威力
 *
 * @author hetao
 * @create 2018-07-16 下午3:37
 */
public class TestStream {


    public static void main(String[] args) {
        List<Integer> list = createList(100 * 100 * 100);

        long time = System.currentTimeMillis();
        testStreamMax(list);
        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();
        testParallelStreamMax(list);
        System.out.println(System.currentTimeMillis() - time);

    }

    public static List<Integer> createList(int num) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random(100*10);
        while (num > 0) {
            num--;
            list.add(random.nextInt());
        }
        return list;
    }

    public static void testParallelStreamMax(List<Integer> list) {

        int max =  list.parallelStream().max(Integer::compareTo).get();
        System.out.println("testParallelStreamMax max"+max);
    }

    public static void testStreamMax(List<Integer> list) {

        int max = list.stream().max(Comparator.naturalOrder()).get();

        System.out.println("testStreamMax max"+max);
    }


}
