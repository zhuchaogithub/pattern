package com.zxc.base.study.basicknowledge;

import java.util.Date;
import java.util.UUID;

/**
 * @author zxc
 * @date 2020/9/24 10:09
 */
public class StringTest {
    /**
     *String+, String.Concat, String.Format, StringBuilder
     * 前三个在100个左右字符串差不多， String.concat会获取稍微好一点点的性能提高， String.format使用起来更方便，StringBuilder适合更多更长的字符串拼接
     *String类其实是通过char数组来保存字符串的，它是final不可变得，所以String的任何改变都不影响原对象，相关的任何change操作都会生成一个新的对象
     */

    public static void main(String[] args) {
        int testLength = 10000;
        String[] arr = new String[100];
        String str = "";

        Date start = new Date();
        String testStr = UUID.randomUUID().toString();
        System.out.println("首次生成randomUUID耗时：" + (new Date().getTime() - start.getTime()));

        start = new Date();
        for (int i = 0; i < testLength; i++) {
            testStr = UUID.randomUUID().toString();
        }
        System.out.println("非首次生成randomUUID " + testLength + "次耗时：" + (new Date().getTime() - start.getTime()));

// String+ 直接被编译器优化成StringBuilder了。
        //(1).String中使用 + 字符串连接符进行字符串连接时，连接操作最开始时如果都是字符串常量，编译后将尽可能多的直接将字符串常量连接起来，形成新的字符串常量参与后续连接（通过反编译工具jd-gui也可以方便的直接看出）；
        //(2).接下来的字符串连接是从左向右依次进行，对于不同的字符串，首先以最左边的字符串为参数创建StringBuilder对象，然后依次对右边进行append操作，最后将StringBuilder对象通过toString()方法转换成String对象（注意：中间的多个字符串常量不会自动拼接）。
        //String c = "xx" + "yy " + a + "zz" + "mm" + b; 实质上的实现过程是： String c = new StringBuilder("xxyy ").append(a).append("zz").append("mm").append(b).toString();
        //由此得出结论：当使用+进行多个字符串连接时，实际上是产生了一个StringBuilder对象和一个String对象。
        start = new Date();
        for (int i = 0; i < testLength; i++) {
            str = testStr + testStr;
        }
        System.out.println("String 拼接测试,测试长度" + testLength + ",测试字符串数组长度" + arr.length + ",完成时间" + (new Date().getTime() - start.getTime()));

//String.concat为什么快？
        //直接Arrays.copyOf，直接内存复制，这根StringBuilder原理类似，但是它不用初始化StringBuilder对象，只是每次concat都会创建一个新的String对象，所以在有些情况下它比StringBuilder要快一点。
        start = new Date();
        for (int i = 0; i < testLength; i++) {
            str = testStr.concat(testStr);
        }
        System.out.println("String.concat 拼接测试,测试长度" + testLength + ",测试字符串数组长度" + arr.length + ",完成时间" + (new Date().getTime() - start.getTime()));

        start = new Date();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testLength; i++) {
            str = "";
           sb.append(testStr);
        }
        str = sb.toString();
        System.out.println("StringBuilder 拼接测试,测试长度" + testLength + ",测试字符串数组长度" + arr.length + ",完成时间" + (new Date().getTime() - start.getTime()));
    }

}
