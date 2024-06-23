package com.cqeec.cjgl.model;

import com.cqeec.cjgl.entity.Grade;

import java.util.ArrayList;

public class GradeModel {
    /**
     * 根据课程编号获取成绩列表
     *
     * @param kcbh 课程编号
     * @return ArrayList<Course> 成绩列表
     */
    public static ArrayList<Grade> getListByKcBh(String kcbh) {
        // 1 创建新的列表
        ArrayList<Grade> list = new ArrayList<>();
        // 2 对成绩列表进行遍历， 如果是要求的课程
        for (Grade grade : GradeModel.getGrades()) {
            if (grade.getKcbh().equals(kcbh)) {
                // 3 将课程添加到新的列表中
                list.add(grade);
            }
        }
        // 3 返回结果
        return list;
    }

    /**
     * 获取所有成绩的信息
     *
     * @return ArrayList<Grade> 返回成绩信息
     */
    public static ArrayList<Grade> getGrades() {
        return DataGrade.grades;
    }

}
