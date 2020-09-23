package com.zxc.base.study.basicknowledge.patternandmatcer;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zxc
 * @date 2020/9/23 17:41
 */
public class PatternMatcherStudy {
    /**
     * Pattern类用于创建一个正则表达式，也可以说是创建一个匹配模式，
     */

    public static void main(String[] args) {
        //* 可以通过两个静态方法创建：compile(String regex)和compile(String regex,int flags)，
        //* 其中regex是正则表达式，flags为可选模式(如：Pattern.CASE_INSENSITIVE 忽略大小写)

//        Pattern pattern = Pattern.compile("Java");
        Pattern pattern = Pattern.compile("\\[(.*?)]", Pattern.CASE_INSENSITIVE);
        System.out.println(pattern.pattern());//返回此模式的正则表达式: Java,  \[(.*?)]
        System.out.println(pattern.flags()); //返回flags
    }

    //根据匹配模式拆分输入序列: split(CharSequence input) 和split(CharSequence input, int limit)
    //当limit值大于所能返回的字符串的最多个数或者为负数，返回的字符串个数将不受限制，但结尾可能包含空串，而当limit=0时与split(CharSequence input)等价，但结尾的空串会被丢弃
    @Test
    public void test(){
        Pattern pattern = Pattern.compile("Java");
        String test="123Java456Java789Java";
        String[] result = pattern.split(test);
        for(String s : result)
            System.out.println(s);

        System.out.println("*******");
        result = pattern.split(test,10);
        System.out.println(result.length);
        System.out.println(Arrays.toString(result));
        System.out.println("*******");
        result = pattern.split(test,-2);
        System.out.println(result.length);
        System.out.println(Arrays.toString(result));
        System.out.println("*******");
        result = pattern.split(test,0);
        System.out.println(result.length);
        System.out.println(Arrays.toString(result));
    }

    /**
     * Matcher类
     */
    @Test
    public void test1(){
//matches(String regex, CharSequence input): 只能进行全字符串匹配并且只能返回是否匹配上的boolean值
        String test11 = "Java";
        String test21 = "Java123456";
        System.out.println(Pattern.matches("Java", test11)); //true
        System.out.println(Pattern.matches("Java", test21)); //false
//lookingAt()，find()，find(int start): lookingAt从字符串最开头开始匹配满足的子串，
//  find可以对任意位置字符串匹配,其中start为起始查找索引值。
        Pattern pattern = Pattern.compile("Java");
        String test1 = "Java";
        String test2 = "Java1234";
        String test3 = "1234Java";
        Matcher matcher = pattern.matcher(test1);
        System.out.println(matcher.matches());//返回true
        matcher = pattern.matcher(test2);
        System.out.println(matcher.matches());//返回false

        matcher = pattern.matcher(test2);
        System.out.println(matcher.lookingAt());//返回true
        matcher = pattern.matcher(test3);
        System.out.println(matcher.lookingAt());//返回false

        matcher = pattern.matcher(test1);
        System.out.println(matcher.find());//返回true
        matcher = pattern.matcher(test2);
        System.out.println(matcher.find());//返回true
        matcher = pattern.matcher(test3);
        System.out.println(matcher.find(2));//返回true
        matcher = pattern.matcher(test3);
        System.out.println(matcher.find(5));//返回false
    }

    @Test
    public void test2(){
// Matcher类提供了start()，end()，group()分别用于返回字符串的起始索引，结束索引，以及匹配到到的字符串。
        Pattern pattern1 = Pattern.compile("Java");
        String test = "123Java456";

        Matcher matcher1 = pattern1.matcher(test);
        matcher1.find();
        System.out.println(matcher1.start());//返回3
        System.out.println(matcher1.end());//返回7
        System.out.println(matcher1.group());//返回Java

        String str = "Hello,World! in Java.";
        Pattern pattern = Pattern.compile("W(or)(ld!)");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.println("Group 0:"+matcher.group(0));//得到第0组——整个匹配
            System.out.println("Group 1:"+matcher.group(1));//得到第一组匹配——与(or)匹配的
            System.out.println("Group 2:"+matcher.group(2));//得到第二组匹配——与(ld!)匹配的，组也就是子表达式
            System.out.println("Start 0:"+matcher.start(0)+" End 0:"+matcher.end(0));//总匹配的索引
            System.out.println("Start 1:"+matcher.start(1)+" End 1:"+matcher.end(1));//第一组匹配的索引
            System.out.println("Start 2:"+matcher.start(2)+" End 2:"+matcher.end(2));//第二组匹配的索引
            System.out.println(str.substring(matcher.start(0),matcher.end(1)));//从总匹配开始索引到第1组匹配的结束索引之间子串——Wor
        }

    }
}
