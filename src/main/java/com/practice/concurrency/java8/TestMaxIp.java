package com.practice.concurrency.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 利用java8获取最大ip
 *
 * @author hetao
 * @create 2018-07-16 下午3:42
 */
public class TestMaxIp {


    public static void main(String[] args) {
        List<String> list = Arrays.asList("192.168.60.4", "192.168.27.9", "192.168.46.5", "192.168.33.3", "192.168.78.3");
        maxIp(list);

    }
    public static Integer testStreamMax(List<Integer> list) {

        int max = list.stream().max(Comparator.naturalOrder()).get();
        System.out.println("testStreamMax max"+max);
        return max;
    }

    private static Integer maxIp(List<String> ips) {
        List<Integer> ipInts = new ArrayList<>();
        ips.forEach(x -> {
            int addIp = maxAddIp(x);
            ipInts.add(addIp);
        });

        System.out.println("TestMaxIp.maxIp ipInts: " +  ipInts.toString());
        Integer maxIp = testStreamMax(ipInts);
        return maxIp;
    }
    /**
     * 把ip转成int类型
     * @param ip
     * @return
     */
    private static int maxAddIp(String ip) {
        String[] array = ip.split("\\.");
        int maxIntIp = 0;
        for (String str : array) {
            maxIntIp = maxIntIp + Integer.parseInt(str);
        }
        return maxIntIp;
    }
}
