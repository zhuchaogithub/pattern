package com.zxc.base.study.practice.strategy;

/**
 * @author zxc
 * @date 2021/3/10 10:27
 */
public class StrategyTest {

    public static void main(String[] args) {
       CarServiceFactory carServiceFactory = new CarServiceFactory("BM");
        CarService carService = carServiceFactory.getCarService();
        carService.create();
    }
}
