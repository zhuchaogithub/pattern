package com.zxc.base.study.basicknowledge.lock;

import org.junit.Test;

import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zxc
 * @date 2020/10/10 10:54
 */
public class ReentrantLockStudy {

    private static final Lock lock = new ReentrantLock(true); // 参数为true，表明实现公平锁机制

    public static void main(String[] args) {
        new Thread(() -> test(), "线程A").start();
        new Thread(() -> test(), "线程B").start();
    }

    public static void test(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+ "获得了锁");
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName() + "释放了锁");
            lock.unlock();
        }
    }

}


