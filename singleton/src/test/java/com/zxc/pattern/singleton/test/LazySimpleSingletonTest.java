package com.zxc.pattern.singleton.test;

import com.zxc.pattern.singleton.lazy.LazySimpleSingleton;

/**
 * @author zxc
 * @date 2020/6/10 15:55
 */
public class LazySimpleSingletonTest {

    public static void main(String[] args) {
//        LazySimpleSingleton.getInstance();
        Thread thread1 = new Thread(new ExectorThread());
        Thread thread2 = new Thread(new ExectorThread());

        thread1.start();
        thread2.start();

        System.out.println("结束");
    }
}
