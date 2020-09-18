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
    //还是创建了两次，发生在jvm层面，相对来说比较安全
    //之前反序列化出来的对象会被GC回收
    private Object readResolve() {
        return INSTANCE;
    }


}
