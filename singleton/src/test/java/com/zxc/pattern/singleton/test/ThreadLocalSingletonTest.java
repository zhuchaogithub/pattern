package com.zxc.pattern.singleton.test;

import com.zxc.pattern.singleton.threadlocal.ThreadLocalSingleton;

/**
 * @author zxc
 * @date 2020/6/15 16:43
 */
public class ThreadLocalSingletonTest {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());
        t1.start();
        t2.start();

        System.out.println("END");
    }
}
