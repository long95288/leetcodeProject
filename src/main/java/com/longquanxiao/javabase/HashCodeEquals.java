package com.longquanxiao.javabase;

import java.util.HashSet;
import java.util.Set;

/**
 * 关于hashCode和equals
 * @author longquanxiao
 * @date 2019/9/10
 */
public class HashCodeEquals {
    public static void main(String[] args){
        Set<Student> set = new HashSet<>();
        Student student1 = new Student("WangWu",12);
        Student student2 = new Student("WangWu", 12);

        // 比较hash值
        System.out.println("hashCode");
        System.out.println("Student1:\t"+student1.hashCode());
        System.out.println("Student2:\t"+student2.hashCode());
        // 放进set里面
        set.add(student1);
        set.add(student2);
        // 查看set中的元素是否重复被覆盖
        System.out.println(set);
        // 查看相等
        System.out.println("Student1 equals Student2:\t" + student1.equals(student2));
        String a1 = "Hello World";
        String a2 = "Hello World";
        System.out.println("a1 == a2:\t" + (a1 == a2));
        System.out.println("al equals a2:\t"+(a1.equals(a2)));
        String a3 = new String("Hello World");
        String a4 = new String("Hello World");
        System.out.println("a3 == a4:\t"+(a3 == a4));
        System.out.println("a3 equals a4:\t"+(a3.equals(a4)));

    }
}
