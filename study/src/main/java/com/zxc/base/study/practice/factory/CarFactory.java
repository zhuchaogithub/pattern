package com.zxc.base.study.practice.factory;

/**
 * @author zxc
 * @date 2021/3/10 9:27
 */
public class CarFactory {

    public Car create(Class clazz){
            try {
                if (clazz != null) {
                    return (Car) clazz.newInstance();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return null;
    }
}
