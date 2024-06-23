package com.cqeec.cjgl.model;

import com.cqeec.cjgl.entity.Grade;

import java.util.ArrayList;

public class DataGrade {
    public static ArrayList<Grade> grades = new ArrayList<>();

     // 定义一个静态代码块，初始化成绩信息
    static {
         grades.add(new Grade("01", "01", "92"));
         grades.add(new Grade("02", "01", "66"));
         grades.add(new Grade("03", "01", "55"));
    }


}
