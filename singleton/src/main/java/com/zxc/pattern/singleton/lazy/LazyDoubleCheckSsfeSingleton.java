package com.zxc.pattern.singleton.lazy;

/**
 * @author zxc
 * @date 2020/6/15 19:53
 * 正确的双重检测锁实现单例模式
 * JDK5 以及后续版本扩展了volatile语义，不再允许volatile写操作与其前面的读写操作重排序，也不允许volatile读操作与其后面的读写操作重排序。
 */
public class LazyDoubleCheckSsfeSingleton {

    private static volatile LazyDoubleCheckSsfeSingleton instance = null;

    private LazyDoubleCheckSsfeSingleton() {}

    public static LazyDoubleCheckSsfeSingleton getInstance() {
        if (instance == null) {
            synchronized (LazyDoubleCheckSsfeSingleton.class) {
                if (instance == null) {
                    instance = new LazyDoubleCheckSsfeSingleton();
                }
            }
        }
        return instance;
    }
}
