package com.zxc.pattern.singleton.threadlocal;

/**
 * @author zxc
 * @date 2020/6/15 16:17
 */
//伪线程安全  （注册式单例（容器式））
public class ThreadLocalSingleton {

    private ThreadLocalSingleton() {
    }

    private static final ThreadLocal<ThreadLocalSingleton> threadLocal = new ThreadLocal<ThreadLocalSingleton>() {
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    public static ThreadLocalSingleton getInstance(){
        return threadLocal.get();
    }
}
