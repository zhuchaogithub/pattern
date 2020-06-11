package com.zxc.pattern.singleton.lazy;

/**
 * @author zxc
 * @date 2020/6/10 15:51
 */
public class LazyDoubleCheckSingleton {

    private static LazyDoubleCheckSingleton lazy = null;

    private LazyDoubleCheckSingleton(){}

    public static LazyDoubleCheckSingleton getInstance(){
        if (lazy == null){
            synchronized (LazyDoubleCheckSingleton.class){
                if (lazy == null){
                    lazy =  new LazyDoubleCheckSingleton();
                }
            }
        }
         return lazy;
    }
}
