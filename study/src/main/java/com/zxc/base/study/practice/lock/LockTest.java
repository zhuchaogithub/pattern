package com.zxc.base.study.practice.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zxc
 * @date 2021/3/10 14:24
 */
public class LockTest {
    private ArrayList<Integer> arrayList = new ArrayList<>();
    Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        final LockTest test = new LockTest();

        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();

        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
    }

    public void insert(Thread thread){
//        Lock lock = new ReentrantLock();   //lock变量是局部变量，每个线程执行该方法时都会保存一个副本，那么理所当然每个线程执行到lock.lock()处获取的是不同的锁，所以就不会发生冲突。
        lock.lock();
        try {
            System.out.println(thread.getName()+"得到了锁");
            for(int i=0;i<5;i++) {
                arrayList.add(i);
            }
            System.out.println(thread.getName()+"执行结果"+ arrayList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(thread.getName()+"释放了锁");
            lock.unlock();
        }
    }
}
