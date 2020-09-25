package com.zxc.base.study.basicknowledge.stream;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * @author zxc
 * @date 2020/9/24 18:45
 */
public class CollectorsStudy {

//Function.identity()
    @Test
    public void functionTest(){
//Java 8允许在接口中加入具体方法。接口中的具体方法有两种，default方法和static方法，identity()就是Function接口的一个静态方法。
        //源码如下：
//        static <T> Function<T, T> identity() {
//            return t -> t;
//        }
    //str -> str和Function.identity()是没什么区别的因为它们都是t->t。但是我们有时候不能使用Function.identity
        List list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int[] arrayOK = list.stream().mapToInt(i -> (int) i).toArray();
//        int[] arrayProblem = list.stream().mapToInt(Function.identity()).toArray();  运行的时候就会错误，因为mapToInt要求的参数是ToIntFunction类型，但是ToIntFunction类型和Function没有关系
        System.out.println(arrayOK);
    }

    @Test
    public void test(){
        //toList()
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
        List<String> result = givenList.stream().collect(toList());
        System.out.println(result);  //[a, bb, ccc, dd]
        //toSet()
        Set<String> collect = givenList.stream().collect(toSet());
        System.out.println(collect);  //[bb, dd, a, ccc] 无序
        List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");
        Set<String> collect1 = listWithDuplicates.stream().collect(toSet());
        System.out.println(collect1); // [bb, a, c, d]
        //toCollection()  使用特定实现，需要使用toCollection收集器并提供特定集合实现
        List<String> collect2 = listWithDuplicates.stream().collect(Collectors.toCollection(LinkedList::new));
        Set<String> collect3 = listWithDuplicates.stream().collect(Collectors.toCollection(HashSet::new));
        System.out.println(collect2);  //[a, bb, c, d, bb]
        System.out.println(collect3);  //[bb, a, c, d]
        //toMap()
        Map<String, Integer> collect4 = givenList.stream().collect(Collectors.toMap(Function.identity(), String::length));
        for(Map.Entry<String, Integer> entry : collect4.entrySet()) {
            System.out.print("Key =" + entry.getKey() + ",value=" + entry.getValue() + "\t\t"); //Key =dd,value=2		Key =bb,value=2		Key =a,value=1		Key =ccc,value=3
        }
    }
}
