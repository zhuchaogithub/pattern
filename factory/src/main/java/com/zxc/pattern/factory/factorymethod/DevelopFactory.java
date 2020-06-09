package com.zxc.pattern.factory.factorymethod;

import com.zxc.pattern.factory.DevelopTask;
import com.zxc.pattern.factory.Itask;

/**
 * @author zxc
 * @date 2020/6/9 11:51
 */
public class DevelopFactory implements ITaskFactory {
    @Override
    public Itask create() {
        return new DevelopTask();
    }
}
