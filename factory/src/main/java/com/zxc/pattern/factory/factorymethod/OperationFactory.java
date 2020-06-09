package com.zxc.pattern.factory.factorymethod;

import com.zxc.pattern.factory.Itask;
import com.zxc.pattern.factory.OperationTask;

/**
 * @author zxc
 * @date 2020/6/9 11:51
 */
public class OperationFactory implements ITaskFactory {
    @Override
    public Itask create() {
        return new OperationTask();
    }
}
