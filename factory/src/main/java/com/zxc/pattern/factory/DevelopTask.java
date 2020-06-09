package com.zxc.pattern.factory;

import com.zxc.pattern.factory.Itask;

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
