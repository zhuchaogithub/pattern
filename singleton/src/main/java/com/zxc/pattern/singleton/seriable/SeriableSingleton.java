package com.zxc.pattern.singleton.seriable;

import java.io.Serializable;

/**
 * @author zxc
 * @date 2020/6/11 15:01
 */
//反序列化导致单例破坏
public class SeriableSingleton implements Serializable {

    public final static SeriableSingleton INSTANCE = new SeriableSingleton();

    private SeriableSingleton() {
    }

    public static SeriableSingleton getInstance() {
        return INSTANCE;
    }
   //重写readResolve方法 是为了覆盖反序列化出来的对象
    private Object readResolve() {
        return INSTANCE;
    }


}
