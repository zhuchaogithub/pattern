package com.zxc.pattern.singleton.test;

import com.zxc.pattern.singleton.seriable.SeriableSingleton;

import java.io.*;

/**
 * @author zxc
 * @date 2020/6/11 14:47
 */
public class SeriableSingletonTest {

    public static void main(String[] args) {

        SeriableSingleton s1 = null;
        SeriableSingleton s2 = SeriableSingleton.getInstance();

        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream("SeriableSingleton.obj");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream);
            objectOutputStream.writeObject(s2);
            objectOutputStream.flush();
            objectOutputStream.close();


            FileInputStream fileInputStream = new FileInputStream("SeriableSingleton.obj");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            s1 = (SeriableSingleton) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
