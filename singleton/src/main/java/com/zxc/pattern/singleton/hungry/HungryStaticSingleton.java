package com.zxc.pattern.singleton.hungry;

/**
 * @author zxc
 * @date 2020/6/10 15:44
 */
public class HungryStaticSingleton {

    private static final HungryStaticSingleton hungrySingleton;

    static {
        hungrySingleton = new HungryStaticSingleton();
    }

    private HungryStaticSingleton(){}

    public static HungryStaticSingleton getInstance(){

        return hungrySingleton;
    }

}
