package com.zxc.base.study.practice.lock;

/**
 * @author zxc
 * @date 2021/3/10 11:43
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedTest.test1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2启动");
                synchronizedTest.test1();
            }
        }).start();
    }

    public synchronized void test1() {
        System.out.println("进入test1");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束test1");
    }

    public void test2() {
        System.out.println("执行test2");
    }
}
