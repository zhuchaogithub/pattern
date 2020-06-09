package com.zxc.pattern.factory.abstactfactory;

import com.zxc.pattern.factory.Itask;

/**
 * @author zxc
 * @date 2020/6/9 14:59
 */
//要求所有的子工厂都实现这个工厂
//(一个任务的抽象) 不符合开闭原则，但是扩展性强
public interface ITaskFactory {

    Itask createTask();

    INote createNote();

    IStudy createStudy();
}
