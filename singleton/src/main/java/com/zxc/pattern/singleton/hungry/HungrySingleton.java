package com.zxc.pattern.singleton.hungry;

/**
 * @author zxc
 * @date 2020/6/10 15:44
 */
public class HungrySingleton {

    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){

        return hungrySingleton;
    }

}
