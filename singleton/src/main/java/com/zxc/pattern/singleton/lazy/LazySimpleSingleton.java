package com.zxc.pattern.singleton.lazy;

/**
 * @author zxc
 * @date 2020/6/10 15:51
 */
public class LazySimpleSingleton {

    private static LazySimpleSingleton lazySimpleSingleton = null;

    private LazySimpleSingleton(){}

    public synchronized static LazySimpleSingleton getInstance(){
        if (lazySimpleSingleton == null){
            lazySimpleSingleton =  new LazySimpleSingleton();
        }
         return lazySimpleSingleton;
    }
}
