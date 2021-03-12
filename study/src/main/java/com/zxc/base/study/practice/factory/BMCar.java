package com.zxc.base.study.practice.factory;

/**
 * @author zxc
 * @date 2021/3/10 9:33
 */
public class BMCar implements Car {

    @Override
    public void create() {
        System.out.println("create BM");
    }

    @Override
    public void sales() {
        System.out.println("sales BM");
    }
}
