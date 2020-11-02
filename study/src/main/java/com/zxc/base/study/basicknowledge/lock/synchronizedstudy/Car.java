package com.zxc.base.study.basicknowledge.lock.synchronizedstudy;

/**
 * @author zxc
 * @date 2020/10/29 17:54
 */
public class Car {
    public synchronized void runing1(Thread thread){
        System.out.println(thread.getName()+ " car1 得到锁");
        System.out.println("------ car1 is running ------");
        working();
        System.out.println(thread.getName()+ " car1 释放锁");
        System.out.println();
    }

    public synchronized void runing2(Thread thread){
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
