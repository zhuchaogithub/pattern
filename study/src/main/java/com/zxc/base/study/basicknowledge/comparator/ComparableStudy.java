package com.zxc.base.study.basicknowledge.comparator;

/**
 * @author zxc
 * @date 2020/9/18 10:17
 */
public class ComparableStudy {

    public static void main(String[] args) {
        Student stu[]={new Student("zhangsan",20,90.0f),
                new Student("lisi",22,90.0f),
                new Student("wangwu",20,99.0f),
                new Student("sunliu",22,100.0f)};
        java.util.Arrays.sort(stu);
        for(Student s:stu)
        {
            System.out.println(s);
        }
    }

    /**
     * 实现Comparable接口，并重写compareTo方法，在其中定义排序规则，那么就可以直接调用Java.util.Arrays.sort()来排序
     */
    static class Student implements Comparable<Student>{
        private String name;
        private int age;
        private float score;

        public Student(String name, int age, float score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }

        public String toString()
        {
            return name+"\t\t"+age+"\t\t"+score;
        }

        @Override
        public int compareTo(Student o) {
            if(this.score>o.score)//score是private的，为什么能够直接调用,这是因为在Student类内部
                return -1;//由高到底排序
            else if(this.score<o.score)
                return 1;
            else{
                if(this.age>o.age)
                    return 1;//由底到高排序
                else if(this.age<o.age)
                    return -1;
                else
                    return 0;
            }
        }
    }
}
