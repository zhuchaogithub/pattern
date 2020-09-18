package com.zxc.pattern.singleton.test;

import com.zxc.pattern.singleton.register.EnumSingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * @author zxc
 * @date 2020/6/11 16:05
 */
public class EnumSingletonTest {

//    public static void main(String[] args) {
//
//        EnumSingleton s1 = null;
//        EnumSingleton s2 = EnumSingleton.getInstance();
//        s2.setData(new Object());
//
//        FileOutputStream stream = null;
//        try {
//            stream = new FileOutputStream("EnumSingleton.obj");
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream);
//            objectOutputStream.writeObject(s2);
//            objectOutputStream.flush();
//            objectOutputStream.close();
//
//
//            FileInputStream fileInputStream = new FileInputStream("EnumSingleton.obj");
//            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//            s1 = (EnumSingleton ) objectInputStream.readObject();
//            objectInputStream.close();
//
//            System.out.println(s1.getData());
//            System.out.println(s2.getData());
//            System.out.println(s1.getData() == s2.getData());
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    public static void main(String[] args) {

        try {
            Class clazz = EnumSingleton.class;
//            Constructor c = clazz.getDeclaredConstructor();
//            c.newInstance();
            Constructor c = clazz.getDeclaredConstructor(String.class, int.class);
            c.setAccessible(true);
            EnumSingleton enumSingleton = (EnumSingleton) c.newInstance("1212", 111);
            System.out.println(enumSingleton);

            //从jDK层面就为枚举不被序列化和发射破坏来保驾护航
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
