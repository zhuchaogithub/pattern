package com.zxc.base.study.basicknowledge.stream;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author zxc
 * @date 2020/9/18 14:09
 */
public class StreamTest {

    @Autowired
    private Employee employee;

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18 ,9999.99, Employee.Status.FREE),
            new Employee("李四", 18, 8888.99, Employee.Status.BUSY),
            new Employee("王五", 50, 6666.66, Employee.Status.VOCATION),
            new Employee("赵六", 16, 3333.33, Employee.Status.FREE),
            new Employee("田七", 8, 7777.77, Employee.Status.BUSY)
    );
    @Test
    public void test() {
        List<String> list = Arrays.asList("ccc", "aaa", "bbb", "ddd", "eee");

        //自然排序
        list.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("------------------------------");
        //定制排序
        employees.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).forEach(System.out::println);
        System.out.println("------------------------------");
        employees.stream().sorted((x,y) ->{
            if (x.getAge() == y.getAge()){
                return x.getSalary().compareTo(y.getSalary());
            }else {
                return Integer.compare(x.getAge(),y.getAge());
            }
        }).forEach(System.out::println);
    }

    @Test
    public void test1(){
        //allMatch  检查是否匹配所有元素
        boolean b = employees.stream().allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println("allMatch: "+b);
        //anyMatch 检查是否至少匹配一个元素
        boolean b1 = employees.stream().anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println("anyMatch: " + b1);
        //noneMatch 检查是否没有匹配所有元素
        boolean b2 = employees.stream().noneMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println("noneMatch:" + b2);
        //findFirst---返回第一个元素
        Optional<Employee> first = employees.stream().sorted((x,y) -> Double.compare(x.getSalary(), y.getSalary())).findFirst();
        System.out.println("findFirst: "+first.get());
        //findAny---返回当前流中的任意元素
        Optional<Employee> any = employees.stream().filter(e -> e.getStatus().equals(Employee.Status.BUSY)).findAny();
        System.out.println("findAny: " + any.get());
        //count---返回流中元素的总个数
        long count = employees.stream().count();
        System.out.println("count: " + count);
        //max---返回流中最大值
        Optional<Employee> max = employees.stream().max(Comparator.comparing(Employee::getAge));
        System.out.println("max: "+max.get());
        //min---返回流中最小值
        Optional<Employee> min = employees.stream().min(Comparator.comparing(Employee::getAge));
        System.out.println("min: "+min.get());
    }
}
