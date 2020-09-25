package com.zxc.base.study.basicknowledge.string;

/**
 * @author zxc
 * @date 2020/9/25 16:22
 */
public class StringEqIgCaseTest {
    public static void main(String[] args) {
//      equalsIgnoreCase 方法用于将字符串与指定的对象比较，不考虑大小写。
        String Str1 = new String("runoob");
        String Str2 = Str1;
        String Str3 = new String("runoob");
        String Str4 = new String("RUNOOB");
        boolean retVal;

        retVal = Str1.equals( Str2 );
        System.out.println("返回值 = " + retVal );

        retVal = Str3.equals( Str4);
        System.out.println("返回值 = " + retVal );

        retVal = Str1.equalsIgnoreCase( Str4 );
        System.out.println("返回值 = " + retVal );
    }
}
