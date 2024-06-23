package com.cqeec.cjgl.model;

import com.cqeec.cjgl.entity.Course;

import java.util.ArrayList;

public class DataCourse {
    public static ArrayList<Course> courses = new ArrayList<>();

    // 静态初始化块，初始化课程列表
    static {
        courses.add(new Course("01", "java基础", "77"));
        courses.add(new Course("02", "PHP", "90"));
        courses.add(new Course("03", "javaScript程序设计", "56"));
        courses.add(new Course("04", "工程化模块设计", "100"));
        courses.add(new Course("05", "Vue", "57"));
    }
}

