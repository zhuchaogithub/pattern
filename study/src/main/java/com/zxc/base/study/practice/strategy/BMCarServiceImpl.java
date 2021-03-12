package com.zxc.base.study.practice.strategy;

/**
 * @author zxc
 * @date 2021/3/10 10:20
 */
public class BMCarServiceImpl implements CarService {
    @Override
    public String getType() {
        return "BM";
    }

    @Override
    public void create() {
        System.out.println("create BMCar");
    }
}
