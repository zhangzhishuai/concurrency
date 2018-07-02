package com.practice.concurrency.calculation;

/**
 * calculation
 * 算法基础理解测试
 * 在算法分析中，我们将语句总的执行次数记为T(n)进而分析T(n)随n的变化情况确认T(n)的数量级。
 * 一般情况下，T(n)随n增大变化最缓慢的算法为最优算法。
 *
 * 时间复杂度：
 * 首先要说的是，时间复杂度的计算并不是计算程序具体运行的时间，而是算法执行语句的次数。
 * 当我们面前有多个算法时，我们可以通过计算时间复杂度，判断出哪一个算法在具体执行时花费时间最多和最少。

 * 常见的时间复杂度有：
 * 常数阶O(1),
 * 对数阶O(log2 n),
 * 线性阶O(n),
 * 线性对数阶O(n log2 n),
 * 平方阶O(n^2)，
 * 立方阶O(n^3)
 * k次方阶O(n^K),
 * 指数阶O(2^n)。
 * 随着n的不断增大，时间复杂度不断增大，算法花费时间越多。

 * 计算方法
 * ①选取相对增长最高的项
 * ②最高项系数是都化为1
 * ③若是常数的话用O（1）表示
 * 如f（n）=2*n^3+2n+100则O（n）=n^3。

 * 通常我们计算时间复杂度都是计算最坏情况
 *
 *
 * 空间复杂度
 * 空间复杂度是对一个算法在运行过程中临时占用存储空间大小的量度。
 * 计算方法：
 * ①忽略常数，用O(1)表示
 * ②递归算法的空间复杂度=递归深度N*每次递归所要的辅助空间
 * ③对于单线程来说，递归有运行时堆栈，求的是递归最深的那一次压栈所耗费的空间的个数，
 * 因为递归最深的那一次所耗费的空间足以容纳它所有递归过程。
 *
 * @author hetao
 * @create 2018-07-02 上午10:25
 */
public class CalculationTest {

    public static void main(String[] args) {
//        on();

//        square();

        logn();
    }

    /**
     * 这里int执行一次，for循环里的语句执行n次，所以T(n)=n+1;但是当n变大时，这个常数就显得无足轻重了，所以它的算法复杂度为O(n)。
     */
    private static void on() {
        int i;
        for(i=0;i< 5;i++){
            System.out.println("CalculationTest.main i=" + i );
        }
    }

    /**
     * 这里int执行一次，嵌套的for执行了n*n次，所以T(n)=n^2+1;同理，它的复杂度为O(n^2)。
     */
    private static  void square() {
        int i,j;
        for(i=0;i<5;i++) {
            for(j=0;j<5;j++) {
                System.out.println("CalculationTest.square j = " + j);
            }
        }

    }

    /**
     * 每次执行i都乘以2，设执行次数为x，那么2^x≥n，我们只取等于的情况，得到x=log2n。
     * 所以这个循环的复杂度为O(logn)，底数大小其实在n很大的时候是无足轻重的，所以不做考虑。
     */
    private static void logn() {
        int i=1;
        while(i< 5) {
            i*=2;
            System.out.println("CalculationTest.logn i= " + i);
        }

    }
}
