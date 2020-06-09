package com.zxc.pattern.factory.abstactfactory;

import com.zxc.pattern.factory.DevelopTask;
import com.zxc.pattern.factory.Itask;

/**
 * @author zxc
 * @date 2020/6/9 15:03
 */
public class DevelopFactory implements ITaskFactory {
    @Override
    public Itask createTask() {
        return new DevelopTask();
    }

    @Override
    public INote createNote() {
        return new DevelopNote();
    }

    @Override
    public IStudy createStudy() {
        return new DevelopStudy();
    }
}
