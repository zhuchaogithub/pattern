package com.zxc.base.study.practice.strategy;

/**
 * @author zxc
 * @date 2021/3/10 10:22
 */
public class ADCarServiceImpl implements CarService {
    @Override
    public String getType() {
        return "AD";
    }

    @Override
    public void create() {
        System.out.println("create ADCar");
    }
}
