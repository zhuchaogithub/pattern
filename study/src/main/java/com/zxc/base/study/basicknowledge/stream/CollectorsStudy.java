package com.zxc.base.study.basicknowledge.stream;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

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
        System.out.println();
//toMap甚至不判断值是否相等，如果key重复，立刻抛出IllegalStateException异常。当key冲突时，我们应该使用toMap的另一个重载方法：
        List<String> givenList1 = Arrays.asList("a","a", "bb", "ccc", "dd");
//        Map<String, Integer> collect5 = givenList1.stream()
//                .collect(Collectors.toMap(Function.identity(), String::length));  //java.lang.IllegalStateException: Duplicate key 1
        Map<String, Integer> collect6 = givenList1.stream()
                .collect(Collectors.toMap(Function.identity(), String::length, (item, identicalItem) -> item));
        for(Map.Entry<String, Integer> entry : collect6.entrySet()) {
            System.out.print("Key =" + entry.getKey() + ",value=" + entry.getValue() + "\t\t"); //Key =dd,value=2		Key =bb,value=2		Key =a,value=1		Key =ccc,value=3
        }
        System.out.println();

        //Collectors.collectingAndThen()  是一个特殊收集器，其可以收集完成后再结果上执行另外动作
        ImmutableList<String> collect7 = givenList.stream().collect(Collectors.collectingAndThen(toList(), ImmutableList::copyOf));
        System.out.println("collect7: " + collect7);  //collect7: [a, bb, ccc, dd]

        //Collectors.joining(): 收集器可以用于连接字符串流Stream中的元素
        String collect8 = givenList.stream().collect(joining());
        System.out.println(collect8); //abbcccdd
        System.out.println(givenList.stream().collect(joining(" "))); //a bb ccc dd
        System.out.println(givenList.stream().collect(joining(" ", "PRE-", "-POST"))); //PRE-a bb ccc dd-POST

    }

    @Test
    public void testDifferenceSet() {
        Aa aa = new Aa();
        List<String> set3 = new ArrayList<>();
        set3.add("a");
        set3.add("b");
        set3.add("c");
        set3.add("d");
        aa.setAaaa(set3);

        List<String> set1 = new ArrayList<>();
        List<String> set2 = new ArrayList<>();

        set1.add("a");
        set1.add("b");
        set1.add("c");
//        set1.add("d");

        set2.add("c");
        set2.add("d");
        set2.add("e");
        set2.add("f");
//
//        boolean b = set1.removeAll(set2);
//        System.out.println("差集是 " + set1); //差集是 [a, b]
//        System.out.println("差集是 " + set1.isEmpty()); //差集是 [a, b]
//        System.out.println(b);
        boolean all = aa.getAaaa().removeAll(set1);
        System.out.println(all);
        System.out.println(aa.getAaaa().isEmpty());
    }
}
class Aa {
    private List<String> aaaa;

    public List<String> getAaaa() {
        return aaaa;
    }

    public void setAaaa(List<String> aaaa) {
        this.aaaa = aaaa;
    }
}