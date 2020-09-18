package com.zxc.pattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zxc
 * @date 2020/6/15 10:56
 */
public class ContainerSinglerton {

    private ContainerSinglerton() {
    }

    private static Map<String, Object> ioc = new ConcurrentHashMap<>();

    public static Object getBean(String classnanme) {

        synchronized (ioc) { //并发安全控制
            if (!ioc.containsKey(classnanme)) {
                Object obj = null;
                try {
                    obj = Class.forName(classnanme).newInstance();
                    ioc.put(classnanme, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            }
            return ioc.get(classnanme);
        }
    }
}
