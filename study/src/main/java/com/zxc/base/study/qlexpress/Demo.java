package com.zxc.base.study.qlexpress;

import com.ql.util.express.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author zxc
 * @date 2020/9/23 10:16
 */
public class Demo {

    private ExpressRunner runner = new ExpressRunner();

    //如果性别为“男”，并且 分数 > 80分 那么此人授信500元 ，否则拒绝授信

    @Before
    public void init() throws Exception {
        //逻辑控制符号定义
        runner.addOperatorWithAlias("如果", "if", null);
        runner.addOperatorWithAlias("则", "then", null);
        runner.addOperatorWithAlias("否则", "else", null);
        runner.addOperatorWithAlias("并且", "and", null);
        runner.addOperatorWithAlias("或者", "or", null);

        //指标项定义
        runner.addFunctionOfClassMethod("getAge", Demo.class.getName(), "getAge", new String[]{User.class.getName()}, null);
        runner.addMacro("年龄", "getAge(user)");

        runner.addFunctionOfClassMethod("getJob", Demo.class.getName(), "getJob", new String[]{User.class.getName()}, null);
        runner.addMacro("工作", "getJob(user)");

        // 自定义操作符号   join
        class JoinOperator extends Operator {
            public Object executeInner(Object[] list) throws Exception {
                Object opdata1 = list[0];
                Object opdata2 = list[1];
                if(opdata1 instanceof java.util.List){
                    ((java.util.List)opdata1).add(opdata2);
                    return opdata1;
                }else{
                    java.util.List result = new java.util.ArrayList();
                    result.add(opdata1);
                    result.add(opdata2);
                    return result;
                }
            }
        }
        runner.addOperator("join",new JoinOperator());

        // 自定义操作符  集合加
        class GroupOperator extends Operator {
            public GroupOperator(String aName) {
                this.name= aName;
            }
            public Object executeInner(Object[] list)throws Exception {
                Object result = Integer.valueOf(0);
                for (int i = 0; i < list.length; i++) {
                    result = OperatorOfNumber.add(result, list[i],false);//根据list[i]类型（string,number等）做加法
                }
                return result;
            }
        }
        runner.addFunction("group", new GroupOperator("group"));

    }

    public int getAge(User user){
        return user.getAge();
    }
    public String getJob(User user){
        return user.getJob();
    }

    @Test
    public void testDemo5() throws  Exception{
        String express = "group(1,2,3)";
        System.out.println("表达式计算：" + express + " 处理结果： " + runner.execute(express, null, null, false, false) );
    }

    // +,-,*,/,<,>,<=,>=,==,!=,<>【等同于!=】,%,mod【取模等同于%】,
    @Test
    public void testDemo1() throws Exception{
        ExpressRunner runner = new ExpressRunner();

        String express1 =  "((1+2) >= 3) == false";
        System.out.println("表达式计算：" + express1 + " 处理结果： " + runner.execute(express1, null, null, false, false) );

        String express2 =  "(5 mod 2) != 7";
        System.out.println("表达式计算：" + express2 + " 处理结果： " + runner.execute(express2, null, null, false, false) );
    }

    //  and(&&) or(||)  !(非)  in【类似sql】  like【类似sql】
    @Test
    public  void testDemo2() throws Exception{
        ExpressRunner runner = new ExpressRunner();
        runner.addOperatorWithAlias("如果", "if", null);
//        String express1 = "!(false and true)";
//        System.out.println("表达式计算：" + express1 + " 处理结果： " + runner.execute(express1, null, null, false, false) );

        /**
         * 表达式计算的数据注入接口
         */
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("a",1);
        context.put("b",2);
        context.put("c",3);
//        runner = new ExpressRunner(false,true);
        String express2 = "5 in(a,b,c)";
        String express4 = "a+b*c";
        String express5 = "如果 (true) {false}";
//        System.out.println("表达式计算：" + express2 + " 处理结果： " + runner.execute(express2, context, null, false, false) );
//        System.out.println("表达式计算：" + express4 + " 处理结果： " + runner.execute(express4, context, null, false, false) );
        System.out.println("表达式计算：" + express5 + " 处理结果： " + runner.execute(express5, context, null, false, false) );

//        String express3 = "'abc' like 'ab%'";
//        System.out.println("表达式计算：" + express3 + " 处理结果： " + runner.execute(express3, null, null, false, false) );

    }

    public void permission(User user, String express) throws Exception {
        IExpressContext<String,Object> expressContext = new DefaultContext<String,Object>();
        expressContext.put("user",user);
        int result = (Integer)runner.execute(express, expressContext, null, false, false);
        System.out.println("用户"+user.getName()+"授信："+result);
    }

    // if then else
    @Test
    public void testDemo3() throws Exception{
        init();
//        String express1 = "如果 年龄< 18 则 0 否则 { 如果 年龄 < 30 则 500 否则 {如果 年龄 < 50 则 1000 否则 100}}";
//        User user =   new User("张三",35,"农民");
//        demo.permission(user,express1);
//        runner = new ExpressRunner(false,true);
        String express2 = "如果 true 则 false 否则 true";
        Object execute = runner.execute(express2, null, null, false, false);
        System.out.println("表达式计算结果： " + execute);
        String express3 = "如果 (" + execute + ") 则 true 否则 false";
        System.out.println("表达式计算：" + express2 + " 处理结果： " + runner.execute(express3, null, null, false, false) );
    }

    @Test
    public void testDemo4() throws Exception {
        String express = "1 join 2 join 3";
        Object r = runner.execute(express, null, null, false, false);
        System.out.println("表达式计算：" + express + " 处理结果： " + runner.execute(express, null, null, false, false) );
    }

}
class User {
    private String name;
    private int age;
    private String job;

    public User(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

}