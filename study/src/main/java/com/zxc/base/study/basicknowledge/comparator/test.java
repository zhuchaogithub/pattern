package com.zxc.base.study.basicknowledge.comparator;

import org.junit.Test;

/**
 * @author zxc
 * @date 2020/9/18 14:43
 */
public class test {
    @Test
    public void test(){
        Integer a = 1;
        Integer b = 2;
        Integer d = 1;
        System.out.println( a.compareTo(b)); //小于 -1
        System.out.println( b.compareTo(a)); //大于 1
        System.out.println( a.compareTo(d)); //等于 0
    }
}
