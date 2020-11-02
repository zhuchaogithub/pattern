package com.zxc.base.study.basicknowledge.lock.synchronizedstudy;

/**
 * @author zxc
 * @date 2020/11/2 16:43
 *
 * 产生互斥，因为对静态方法加锁，实际上是对类加锁，类只有一个。因此当一个同步静态方法被访问时，该类已处于被锁状态。
 * 此时其他同步静态方法不能被访问​（未用synchronized修饰的静态方法仍可以访问）
 */
public class Test2 {
    public static void main(String[] args) {
        //线程1 类
        Thread t1 = new Thread(){
            @Override
            public void run() {
                Car1.staticRuning1(Thread.currentThread()); //同步类方法1
            }
        };
        t1.start();

        //线程2 类
        Thread t2 = new Thread(){
            @Override
            public void run() {
                Car1.staticRuning2(Thread.currentThread()); //同步类方法2
            }
        };
        t2.start();
    }
}
class Car1 {
    public static synchronized void staticRuning1(Thread thread){
        System.out.println(thread.getName()+ " car1 得到锁");
        System.out.println("------ car1 is running ------");
        working();
        System.out.println(thread.getName()+ " car1 释放锁");
        System.out.println();
    }

    public static void staticRuning2(Thread thread){
//    public static synchronized void staticRuning2(Thread thread){
        System.out.println(thread.getName()+ " car2 得到锁");
        System.out.println("------ car2 is running ------");
        working();
        System.out.println(thread.getName()+ " car2 释放锁");
        System.out.println();
    }
    public static void  working(){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}