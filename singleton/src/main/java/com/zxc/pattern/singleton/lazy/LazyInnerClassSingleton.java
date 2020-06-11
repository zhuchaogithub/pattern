package com.zxc.pattern.singleton.lazy;

import java.lang.reflect.Constructor;

/**
 * @author zxc
 * @date 2020/6/10 15:51
 */
//静态内部类方式
public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton() {
        //防止反射破坏单例
        if (LazyHolder.lazy != null) {
            throw new RuntimeException("");
        }
    }

    //懒汉式
    public static final LazyInnerClassSingleton getInstance() {
        return LazyHolder.lazy;
    }

    private static class LazyHolder {
        private static final LazyInnerClassSingleton lazy = new LazyInnerClassSingleton();
    }

}
class tt{
    public static void main(String[] args) {
        try {
            Class<?> clazz = LazyInnerClassSingleton.class;
            Constructor c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);
            Object o1 = c.newInstance();

            Object o2 = LazyInnerClassSingleton.getInstance();
            System.out.println(o1 == o2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
