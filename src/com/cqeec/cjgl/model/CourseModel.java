package com.cqeec.cjgl.model;

import com.cqeec.cjgl.entity.Course;

import java.util.ArrayList;

public class CourseModel {
    /**
     * 根据课程名称获取对象
     *
     * @param name 课程名
     * @return Course 返回课程对象
     */
    public static Course getByName(String name) {
        for (Course course : CourseModel.getCourse()) {
            if (course.getKcmc().equals(name)) {
                return course;
            }
        }
        return null;
    }

    /**
     * 获取课程列表方法
     *
     * @return ArrayList<Course> 课程列表
     */
    public static ArrayList<Course> getCourse() {
        return DataCourse.courses;
    }


    /**
     * 删除指定学号的学生
     *
     * @param name 姓名
     */
    public static void delete(String name) {
        Course course = getByName(name);
        if (course != null) {
            DataCourse.courses.remove(course);
        }
    }

    /**
     * 判断参数指定的课程是都存在
     *
     * @param course 课程
     * @return 返回下标 -1
     */
    public static int exist(Course course) {
        for (int i = 0; i < DataCourse.courses.size(); i++) {
            if (DataCourse.courses.get(i).getKcmc().equals(course.getKcmc())) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 保存姓名的对象
     *
     * @param course 要保存的对象
     */
    public static void save(Course course) {
        int index = exist(course);
        if (index == -1) {
            DataCourse.courses.add(course);
        } else {
            DataCourse.courses.set(index, course).toString();
        }
    }
}
