package com.zxc.pattern.singleton.test;

import com.zxc.pattern.singleton.lazy.LazySimpleSingleton;
import com.zxc.pattern.singleton.threadlocal.ThreadLocalSingleton;

/**
 * @author zxc
 * @date 2020/6/10 16:00
 */
public class ExectorThread implements Runnable {

    @Override
    public void run() {
//        LazySimpleSingleton lazySimpleSingleton = LazySimpleSingleton.getInstance();
//        System.out.println(Thread.currentThread().getName() + ":" + lazySimpleSingleton);

        ThreadLocalSingleton threadLocalSingleton = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + threadLocalSingleton);
    }
}
