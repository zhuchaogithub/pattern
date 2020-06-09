package com.zxc.pattern.factory.simplefactory;

import com.zxc.pattern.factory.Itask;

/**
 * @author zxc
 * @date 2020/6/9 10:11
 */
public class TaskFactory {

//    public Itask create(String name){
//        if("develop".equals(name)){
//            return new DevelopTask();
//        }else if ("operation".equals(name)){
//            return new OperationTask();
//        }
//        return null;
//    }

//    public Itask create(String className) {
//        try {
//            if (!(null == className || "".equals(className))) {
//                return (Itask) Class.forName(className).newInstance();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public Itask create(Class clazz) {
        try {
            if (null != clazz) {
                return (Itask) clazz.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
