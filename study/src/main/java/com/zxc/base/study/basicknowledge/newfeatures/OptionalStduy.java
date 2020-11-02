package com.zxc.base.study.basicknowledge.newfeatures;

import org.junit.Test;

import java.util.Optional;

/**
 * @author zxc
 * @date 2020/9/18 16:30
 */
public class OptionalStduy {

    public static void main(String[] args) {
        Student student = new Student("zhangsan", 1, "women");
//        Student student = null;
        System.out.println(getGender(student));
    }

    public static String getGender(Student student) {
//        if (null == student) {
//            return "Unkown";
//        }
//        return student.getGender();
        return Optional.ofNullable(student).map(e -> e.getGender()).orElse("Unkown");
    }

    @Test
    public void test() {
        // 1、创建一个包装对象值为空的Optional对象
        Optional<String> optStr = Optional.empty();
        // 2、创建包装对象值非空的Optional对象
        Optional<String> optStr1 = Optional.of("optional");
        // 3、创建包装对象值允许为空的Optional对象
        Optional<String> optStr2 = Optional.ofNullable(null);

        //get()方法主要用于返回包装对象的实际值，但是如果包装对象值为null，会抛出NoSuchElementException异常。
        System.out.println(optStr1.get());
//        System.out.println(optStr2.get());
//        System.out.println(optStr.get());

        //isPresent()方法 : 用于判断包装对象的值是否非空
        System.out.println(optStr.isPresent()); //空则false
        System.out.println(optStr1.isPresent()); //非空则true

        //ifPresent(): 接受一个Consumer对象（消费函数），如果包装对象的值非空，运行Consumer对象的accept()方法
//        Optional.ofNullable(new Student()).ifPresent(e -> System.out.println(e.getAge()));
        optStr1.ifPresent(u -> System.out.println(u));

        //filter()方法： 接受参数为Predicate对象，用于对Optional对象进行过滤，
        // 如果符合Predicate的条件，返回Optional对象本身，否则返回一个空的Optional对象。
        Student student = new Student("zhangsan", 19, "women");
        Optional.ofNullable(student).filter( u -> u.getAge() > 18).ifPresent(e -> System.out.println("The student age is more than 18."));
        System.out.println(Optional.ofNullable(student).filter( u -> u.getAge() > 18).get().getGender());

        //map()方法； 参数为Function（函数式接口）对象，map()方法将Optional中的包装对象用Function函数进行运算，并包装成新的Optional对象（包装对象的类型可能改变）
        Optional<String> s = Optional.ofNullable(student).map(e -> e.getName());
        System.out.println(s.get());

        //flatMap()方法: 入参Function函数的返回值类型为Optional<U>类型，而不是U类型，这样flatMap()能将一个二维的Optional对象映射成一个一维的对象
        Optional<Integer> integer = Optional.ofNullable(student).flatMap(u -> Optional.ofNullable(u.getAge()));
        System.out.println(integer.get());

        //orElse()方法: 如果包装对象值非空，返回包装对象值，否则返回入参other的值（默认值）
        String unkown = Optional.ofNullable(student).map(e -> e.getGender()).orElse(getDefaultValue());
        System.out.println(unkown);
        System.out.println("---以上为orElse调用,以下为orElseGet调用---");
        //orElseGet()方法: 入参为一个Supplier对象，用Supplier对象的get()方法的返回值作为默认值
        String s1 = Optional.ofNullable(student).map(u -> u.getGender()).orElseGet(() -> getDefaultValue());
        System.out.println(s1);

        //orElseThrow()方法: 入参是Supplier对象，只不过orElseThrow()的Supplier对象必须返回一个Throwable异常，并在orElseThrow()中将异常抛出
        //orElseThrow()方法适用于包装对象值为空时需要抛出特定异常的场景
        String unkown1 = Optional.ofNullable(student).map(u -> u.getGender()).orElseThrow(() -> new RuntimeException("Unkown"));
        System.out.println(unkown1);
    }

    public String getDefaultValue(){  //远程方法调用
        System.out.println("我被调用了!");
        return "我是默认值";
    }
}
