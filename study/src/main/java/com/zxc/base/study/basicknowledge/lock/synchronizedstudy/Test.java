package com.zxc.base.study.basicknowledge.lock.synchronizedstudy;

import java.util.concurrent.CountDownLatch;

/**
 * @author zxc
 * @date 2020/10/29 17:55
 *
 * 两个线程依次执行，说明产生互斥，因为实例方法加锁针对的是实例对象，当前对象调用​一个synchronized方法时，其他同步方法需要等待其执行结束并释放锁之后才能执行。
 */
public class Test {

    private CountDownLatch latch = new CountDownLatch(2);

    @org.junit.Test
    public void test1() throws InterruptedException {
        Car car = new Car();
        //线程1
        Thread t1 = new Thread(){
            @Override
            public void run() {
                car.runing1(Thread.currentThread()); //同步实例方法1
                latch.countDown();
            }
        };
        t1.start();

        //线程2
        Thread t2 = new Thread(){
            @Override
            public void run() {
                car.runing2(Thread.currentThread()); //同步实例方法2
                latch.countDown();
            }
        };
        t2.start();
//        Thread.sleep(100000);    方案一
        // 方案二
        try {
            latch.await(); // 主线程等待
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        //线程1
        Thread t1 = new Thread(){
            @Override
            public void run() {
                car.runing1(Thread.currentThread()); //同步实例方法1
            }
        };
        t1.start();

        //线程2
        Thread t2 = new Thread(){
            @Override
            public void run() {
                car.runing2(Thread.currentThread()); //同步实例方法2
            }
        };
        t2.start();
    }
}
