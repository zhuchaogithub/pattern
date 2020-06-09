package com.zxc.pattern.factory.factorymethod;

import com.zxc.pattern.factory.Itask;

/**
 * @author ZXC
 * @date 2020/6/9 14:34
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
        ITaskFactory factory = new DevelopFactory();
        Itask itask = factory.create();
        itask.create();
    }
}
