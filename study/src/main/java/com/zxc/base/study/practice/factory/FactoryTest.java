package com.zxc.base.study.practice.factory;

/**
 * @author zxc
 * @date 2021/3/10 9:54
 */
public class FactoryTest {

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car car = carFactory.create(AodiCar.class);
        car.create();
        car.sales();
    }
}
