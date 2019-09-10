package com.longquanxiao.javabase;

import java.util.Objects;

/**
 * @author longquanxiao
 * @date 2019/9/10
 */
public class Student {
        public String name;
        public int age;
        public Student(){}
        public Student(String name,int age){
            this.name = name;
            this.age = age;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return age == student.age &&
                name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
}
