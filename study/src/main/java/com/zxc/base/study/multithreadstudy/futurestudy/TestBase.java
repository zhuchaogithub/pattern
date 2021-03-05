package com.zxc.base.study.multithreadstudy.futurestudy;

/**
 * @author zxc
 * @date 2021/2/24 17:15
 */
public class TestBase {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        //等凉菜  必须要等返回的结果，所以要调用join方法
        Thread t1 = new ColdDishThread();
        t1.start();
        t1.join();

        //等包子  必须要等返回结果
        Thread t2 = new BumThread();
        t2.start();
        t2.join();

        long endTime = System.currentTimeMillis();
        System.out.println("准备完毕时间：" + (endTime-startTime));
    }
}
