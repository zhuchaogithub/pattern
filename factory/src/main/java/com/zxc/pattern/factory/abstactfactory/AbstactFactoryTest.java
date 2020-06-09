package com.zxc.pattern.factory.abstactfactory;

/**
 * @author zxc
 * @date 2020/6/9 15:24
 */
public class AbstactFactoryTest {

    public static void main(String[] args) {
        ITaskFactory iTaskFactory = new DevelopFactory();
        iTaskFactory.createTask().create();
        iTaskFactory.createNote();
        iTaskFactory.createStudy();
    }
}
