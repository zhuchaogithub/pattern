package com.zxc.base.study.practice.factory;

/**
 * @author zxc
 * @date 2021/3/10 9:35
 */
public class AodiCar implements Car {
    @Override
    public void create() {
        System.out.println("create aodi");
    }

    @Override
    public void sales() {
        System.out.println("sales aodi");
    }
}
