package com.cqeec.cjgl.model;

import com.cqeec.cjgl.entity.Student;

import java.util.ArrayList;

public class DataStudent {// 泛型
    public static ArrayList<Student> students = new ArrayList<>();
    // 静态初始化学生列表
    static {
        students.add(new Student("01","张三","男"));
        students.add(new Student("02","李四","男"));
        students.add(new Student("03","王五","女"));
    }

}
