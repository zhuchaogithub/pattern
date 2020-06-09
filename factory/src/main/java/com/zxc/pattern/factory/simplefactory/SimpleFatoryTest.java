package com.zxc.pattern.factory.simplefactory;

import com.zxc.pattern.factory.DevelopTask;
import com.zxc.pattern.factory.Itask;

/**
 * @author zxc
 * @date 2020/6/9 10:08
 */
public class SimpleFatoryTest {

    public static void main(String[] args) {

        TaskFactory factory = new TaskFactory();
//        Itask itask = new DevelopTask();
//        Itask itask = factory.create("develop");
//        Itask itask = factory.create("com.zxc.pattern.factory.OperationTask");
        Itask itask = factory.create(DevelopTask.class);
        itask.create();

    }
}
