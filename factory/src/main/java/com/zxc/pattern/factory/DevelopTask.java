package com.zxc.pattern.factory;

/**
 * @author zxc
 * @date 2020/6/9 10:05
 */
public class DevelopTask implements Itask {
    @Override
    public void create() {
        System.out.println("develop start");
    }
}
