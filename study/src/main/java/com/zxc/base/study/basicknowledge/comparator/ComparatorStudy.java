package com.zxc.base.study.basicknowledge.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author zxc
 * @date 2020/9/18 10:29
 */
public class ComparatorStudy {

    public static void main(String[] args) {
//        Student stu[]={new Student("zhangsan",20,90.0f),
//                new Student("lisi",22,90.0f),
//                new Student("wangwu",20,99.0f),
//                new Student("sunliu",22,100.0f)};
//        java.util.Arrays.sort(stu,new StudentComparator());
//        for(Student s:stu)
//        {
//            System.out.println(s);
//        }
        ArrayList<Student> st=new ArrayList<Student>();
        Student s1= new Student("lisi",22,90.0f);
        Student s2= new Student("zhangsan",20,90.0f);
        Student s3= new Student("wangwu",20,99.0f);
        Student s4= new Student("sunliu",22,100.0f);
        st.add(s1);
        st.add(s2);
        st.add(s3);
        st.add(s4);
        System.out.println("全部的学生：");
        Collections.sort(st,new StudentComparator());
        for(Student s:st)
        {
            System.out.println(s);
        }
    }

    static class Student {
        private String name;
        private int age;
        private float score;

        public Student(String name, int age, float score) {
            this.name = name;
            this.age = age;
            this.score = score;
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
        public float getScore() {
            return score;
        }
        public void setScore(float score) {
            this.score = score;
        }

        public String toString()
        {
            return name+"\t\t"+age+"\t\t"+score;
        }

    }

    /**
     * compareTo(T o)只有一个参数，而Comparator接口中必须要实现的compare(T o1,T o2)就有两个参数,即stu对象数组，以及重写的实现了comparator比较方法类。
     */
    static class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if(o1.getScore()>o2.getScore())
                return -1;
            else if(o1.getScore()<o2.getScore())
                return 1;
            else{
                if(o1.getAge()>o2.getAge())
                    return 1;
                else if(o1.getAge()<o2.getAge())
                    return -1;
                else
                    return 0;
            }
        }

    }
}
