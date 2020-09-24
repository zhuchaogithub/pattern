package com.zxc.base.study.basicknowledge.apachecommons;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.Test;

/**
 * @author zxc
 * @date 2020/9/24 16:18
 */
public class PairStudy {
    /**
     * MutablePair可以改变值得Pair左右元素对, ImmutablePair不可变的左右元素对
     */
    @Test
    public void test(){
        Pair<Integer, String> of = Pair.of(1,"2");
        System.out.println(of.getLeft());  //1
        System.out.println(of.getRight()); //2
        System.out.println(of.getKey());   //1
        System.out.println(of.getValue()); //2
        System.out.println(of.getClass()); //class org.apache.commons.lang3.tuple.ImmutablePair
        of.setValue("12");
        System.out.println(of.getRight());
    }

    @Test
    public void test1(){
        Triple<String, Integer, String> pair = Triple.of("姓名", 10, "邮箱");
        String name = pair.getLeft(); //姓名
        Integer age = pair.getMiddle(); //10
        String mail = pair.getRight(); //邮箱
        System.out.println(name);
        System.out.println(age);
        System.out.println(mail);

    }

}
