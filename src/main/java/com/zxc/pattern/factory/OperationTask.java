package com.zxc.pattern.factory;

/**
 * @author zxc
 * @date 2020/6/9 10:07
 */
public class OperationTask implements Itask {
    @Override
    public void create() {
        System.out.println("operation start");
    }
}
