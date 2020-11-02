package com.zxc.base.study.basicknowledge.lock.synchronizedstudy;

/**
 * @author zxc
 * @date 2020/10/30 11:06
 *
 * 两个线程同时进行，因为是两个对象，实例方法加锁针对的是实例对象，并不是方法，所以可以并发执行，不会互斥。
 */
public class Test1 {

    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();

        //线程1 对象1
        Thread t1 = new Thread() {
            @Override
            public void run() {
                car1.runing1(Thread.currentThread()); //同步实例方法1
            }
        };
        t1.start();

        //线程2 对象2
        Thread t2 = new Thread() {
            @Override
            public void run() {
                car2.runing1(Thread.currentThread()); //同步实例方法1
            }
        };
        t2.start();
    }
}
