package com.zxc.pattern.singleton.register;

/**
 * @author zxc
 * @date 2020/6/11 16:01
 */
public enum EnumSingleton {

    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
