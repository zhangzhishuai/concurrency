package com.practice.concurrency.synchronize;

/**
 * synchronized实现同步
 *
 * @author hetao
 * @create 2018-06-15 下午5:05
 */
public class SynchronizedTest {

    int i = 5;
    public int simpleField = 100;

    public static int simpleFields = 200;

    public final int simpleFieldf = 200;

    public synchronized void test1() {
        int j = 69;

    }

    public void test2() {

        synchronized (this) {

        }
    }


    public int greaterThen(int intOne, int intTwo) {
        if (intOne > intTwo) {
            return 0;
        } else {
            return 1;
        }
    }

    public int greaterThen1(float floatOne, float floatTwo) {
        int result;
        if (floatOne > floatTwo) {
            result = 1;
        } else {
            result = 2;
        }
        return result;
    }
}
